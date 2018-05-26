import matplotlib.pyplot as plt
import numpy as np, json
from sklearn import datasets

def f(x):
    return 1/(1+25*x*x)
    
def parabola_doubled(n=25):
    X = np.zeros(n)
    y = np.zeros(n)
    for i in range (n):
        X[i] = 4*(i-1)/(n-1)-2
        y[i] = f(X[i])
        
    # fake parameters
    X = X[:, np.newaxis] #create matrix
    X = np.concatenate((X,X*2,X*2),axis=1)
    return X,y

def normalize(X):
    res = X.copy()
    for j in range(res.shape[1]):
        minx = X[...,j].min()
        maxx = X[...,j].max()
        res[...,j] = 2*(res[...,j] - minx) / (maxx - minx) - 1
    return res
    
def boston(l=100):
    boston = datasets.load_boston()
    X = boston.data[:l,...]
    X = np.delete(X, 3, axis=1)
    y = boston.target[:l,...]
    X = normalize(X)
    names = boston["feature_names"]
    return X, y, names
    
def GenerateSampleGenetic():
    l = 200
   
    # real parameters
    real = 10
    X = np.random.randn(l,real)
    a = np.random.randn(real)
    y = np.zeros(l)
    for i in range(l):
        y[i] = a.dot(X[i,:])
 
    # fake parameters
    fakes = 50
    F = np.zeros((l,fakes))
    for i in range(l):
        for j in range(fakes):
            F[i,j]=np.random.randn(1)* 10
    Xp = np.concatenate((X,F),axis=1)
 
    # shuffle columns
    perm = np.arange(real+fakes)
    np.random.shuffle(perm)
 
    return Xp[:,perm], y
    
class DataFactory:
    def createData(self, name):
        if name == 'parabola_2':
            return parabola_doubled()
        elif name == 'iris':
            iris = datasets.load_iris()
            return iris.data[:,[2,3]], iris.target
        elif name == 'boston':
            return boston()
        elif name == 'forGenetic':
            return GenerateSampleGenetic()
        else:
            assert 0

