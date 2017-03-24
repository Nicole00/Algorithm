#coding=utf-8
import math
import csv
import random
import operator

#将数据拆分成训练集和测试集
def loadDataset(filename, split, trainingSet=[], testSet=[]):
    with open(filename, 'rb') as csvfile:
        lines = csv.reader(csvfile)
        dataset = list(lines)
        for x in range(len(dataset) - 1):
            for y in range(4):
                dataset[x][y] = float(dataset[x][y])
            if random.random() < split:
                trainingSet.append(dataset[x])
            else:
                testSet.append(dataset[x])



#测出每组对应的欧氏距离
def Distance (instance1, instance2, length):
    distance = 0
    for x in range(length):
        distance += pow(((instance1[x]) - (instance2[x])), 2)
    return math.sqrt(distance)


#获取与实例最近的K个近邻
def getKNN(trainingSet, testInstance, K):
    distances = []
    length = len(testInstance) - 1
    for x in range(len(trainingSet)):
        dist = Distance(testInstance, trainingSet[x], length)
        distances.append((trainingSet[x], dist))
    #对列表按照第二个元素即距离进行升序排列
    distances.sort(key=operator.itemgetter(1))
    neighbors = []
    #得到距离最小的前K个邻居
    for x in range(K):
        neighbors.append(distances[x][0])
    return neighbors

#获取邻居的反馈
def getResponse(neighbors):
    classVotes = {}
    for x in range(len(neighbors)):
        response = neighbors[x][-1]
        if response in classVotes:
            classVotes[response] += 1
        else:
            classVotes[response] = 1
    sortedVote = sorted(classVotes.items(), key=lambda item:item[1], reverse=True)
    return sortedVote[0][0]

#计算预测精度
def getAccuracy(testSet, predictions):
    correct = 0
    for x in range(len(testSet)):
        if testSet[x][-1] == predictions[x]:
            correct += 1
    return (correct/float(len(testSet)))*100.0

def main():
    trainingSet = []
    testSet = []
    split = 0.67
    loadDataset('F:\wcy\Iris.csv', split, trainingSet, testSet)
    print 'Train: ' + repr(len(trainingSet))
    print 'Test: ' + repr(len(testSet))

    predictions =[]
    k = 30

    for x in range(len(testSet)):
        neighbors = getKNN(trainingSet, testSet[x], k)
        results = getResponse(neighbors)
        predictions.append(results)
        print ('Predicted= ' + repr(results) + ',actual= ' + repr(testSet[x][-1]))
    print len(predictions)
    accuracy = getAccuracy(testSet, predictions)
    print ('Accuracy= ' + repr(accuracy))

main()
