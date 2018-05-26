import numpy as np
import matplotlib.pyplot as plt
import scipy.linalg
import dataBuilder as data
import random
 
#-----------------------------------------Linear reg----------------------
#generate true X
def PolynomialFitures2(X):
    res = []
    n = X.shape[1]
    for i in range(n):
        res.append(X[...,i])
    for i in range(n):
        for j in range(i,n):
            res.append(X[...,i] * X[...,j])
    return np.array(res).T
 
def Linear(X, y, reg=1e-8):
    l, n = X.shape
    return np.linalg.solve(X.T.dot(X) + reg * np.eye(n),X.T.dot(y))
 
def SSE(y_hat, y):
    return ((y_hat-y)**2).sum()/y.shape[0]
 
def LinearError(X,y,take=20):
    l = y.shape[0]
    np.random.seed(123)
    p = np.random.permutation(l)
    X_train = X[p[:take],...]
    y_train = y[p[:take],...]
    X_test = X[p[take:],...]
    y_test = y[p[take:],...]
    w = Linear(X_train, y_train)
    y_hat = []
    for i in range(X_test.shape[0]):
        y_hat.append(np.sum(w * X_test[i,...]))
    return SSE(y_hat, y_test)
 
#-----------------------------------------Genetic---------
 
class Chromosom:
    def __init__(self, mask, err):
        self.mask = mask
        self.err = err
    def val(self): #sort by vozrast
        return self.err
    def Print(self):
        print(self.mask,"  ",self.err)
 
def randMask(n) :
    used = np.zeros(n)
    for i in range(n):
        used[i] = random.randint(0,1)
    return used
 
def getFeatures(X,mask):
    return X[...,np.array(mask,dtype=np.bool)]
 
# Error = ERROR + count ONES from mask
def Loss(X, y, mask):
    newX = getFeatures(X,mask)
    if np.sum(mask) == 0: return 1000
    return ( LinearError(newX,y) + mask.sum() / 100)
 
def mutation(mask):
    n = len(mask)
    pos = random.randint(0,n-1)
    mask[pos] = 1-mask[pos]
    return mask
 
def cross(m1, m2):
    n = len(m1)
    take = random.randint(0,n-1)
    M1 = np.concatenate( (m1[:take],m2[take:]),axis=0 )
    M2 = np.concatenate( (m2[:take],m1[take:]),axis=0 )
    return M1, M2
 
def getChromId(P, p):
    sum = 0; k = len(P)
    for i in range (k):
        sum += P[i]
        if p <= sum : return i
    return (k-1)
 
#k - gen at first stage, even; elite - go without change
def Genetic(X,y, k=60, mutate_prob = 0.1, elite = 2):
    l,n = X.shape
    bestMask = None; bestQ = -1
    allQ=[]
 
    chroms = []
    for i in range(k):
        mask = randMask(n)
        chroms.append( Chromosom(mask, Loss(X,y,mask)) )
 
    for step in range(200):
        chroms = sorted(chroms, key=lambda x: x.val())
 
        #prepeare Fitness selection
        P = np.zeros(k); sum = 0;
        maxv = 0
        for i in range (k):
            sum += chroms[i].err
            maxv = max(maxv, chroms[i].err+1)
        #norm P
        for i in range(k):
            P[i] = (maxv - chroms[i].err)/sum
 
        #get new chromosomes
        Next = []
        for i in range (elite):
            Next.append(chroms[i])
 
        while len(Next) < k:
            #select 2 random chromes
            p = random.random()
            pos1 = getChromId(P, p)
            p = random.random()
            pos2 = getChromId(P, p)
            if pos1 == pos2 : pos2 = (pos2 + 1)%k
 
            #cros them
            m1, m2 = cross(chroms[pos1].mask,chroms[pos2].mask)
            #make mutaton
            p = random.random()
            if p <= mutate_prob:
                m1 = mutation(m1); m2 = mutation(m2)
            #add them
            a = Chromosom(m1, -1)
            b = Chromosom(m2, -1)
            Next.append(a)
            Next.append(b)
 
        chroms = Next
 
        #get best error, set chroms error
        err = -1; mask = None
        for i in range (k):
            chroms[i].err = Loss(X,y,chroms[i].mask)
            if err == -1 or chroms[i].err < err :
                err = chroms[i].err
                mask = chroms[i].mask
 
        if step%50 == 0 :
            print(err)
            # print(Loss(X,y,np.ones(X.shape[1])))
            # quit()
            # for i in chroms:
                # print(i.mask, i.err)
            # print(k)
 
 
        if bestQ == -1 or err < bestQ :
            bestQ = err; bestMask = mask
            print("\nI got new set")
            print("err ",bestQ)
            print("mask ",mask)
 
    return bestMask, bestQ
 
#X,y = data.DataFactory().createData('forGenetic')
X,y,names = data.DataFactory().createData('boston')
 
mask, Q = Genetic(X,y)
print("final error ", (Q - mask.sum()))
 
E = []
for i in range(len(mask)):
    if mask[i] == 1 :
        E.append(i)
print("final set ", E)