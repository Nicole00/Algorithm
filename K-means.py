#coding=utf-8
# @author Nicole

import math
import csv
from numpy import *

#将数据读取到二维数组中
def loadData(filename):
    with open(filename, 'rb') as csvfile:
        lines = csv.reader(csvfile)
        dataset = list(lines)
        for x in range(len(dataset) - 1):
            for y in range(4):
                dataset[x][y] = float(dataset[x][y])
    return dataset


#随机生成K个初始质心
def initKCore(dataset, k):
    cores = []
    length = len(dataset)
    while len(cores) < k:
        randomNumber = random.randint(0, length)
        if dataset[randomNumber] in cores:
            continue
        else:
            cores.append(dataset[randomNumber])
    return cores


#测试
# dataset = loadData('F:\wcy\Iris.csv')
# cores = initKCore(dataset, 3)
# print cores



#计算两个实例之间的欧氏距离
def distance(instance1, instance2, length = 4):
    distance = 0.0
    for i in range(length):
        distance += power((double(instance1[i]) - double(instance2[i])), 2)
    return math.sqrt(distance)

#根据选定的K个质心，决定当前元组属于哪个簇
def Clusters(instance, cores, k):
    dist = distance(instance,cores[0])
    label = 0
    for i in range(1, k):
        temp = distance(instance, cores[i])
        if temp < dist:
            dist = temp
            label = i
    return label

#更新簇的质心，取每个簇中的平均值
def getCore(data):
    length = len(data)-1
    core = []
    for i in range(4):
        sum = 0.0
        for d in data:
            sum += double(d[i])
        ave = sum / len(data)
        core.append(ave)
    return core



def k_means(dataset, cores, k):
    cluserChanged = True
    iterTimes = 0

    while cluserChanged and iterTimes < 100:   #当簇稳定或者循环达100次时跳出循环
        cluserChanged = False

        #将dataset所有元素分配到map中，key为K个label簇，value为对应簇中的点集 {k,[ []  ]}value 是list类型，list中的元素为多个数据组
        map = {}
        data = [ [] for i in range(k)]
        for instance in dataset:
            label = Clusters(instance, cores, k)
            for i in range(k):
                if label == i:
                    data[i].append(instance)
        for i in range(k):
            map[i] = data[i]


        #获取簇中的新质心
        new_cores = []
        for i in range(k):
            dat = map.get(i)
            # if iterTimes == 0:
            #     print data, "\t"
            new_core = getCore(dat)
            new_cores.append(new_core)         #得到新的K个质心

            if new_core != cores[i]:           #如果质心有变化，则簇未稳定
                cluserChanged = True
        cores = new_cores

        iterTimes += 1
    return map

def main():
    dataset = loadData('F:\wcy\Iris.csv')
    k = 4
    cores = initKCore(dataset, k)
    print "初始质心为:\n ", cores, "\n\n"

    map = k_means(dataset, cores, k)
    for i in range(k):
        print "第 %d 个簇为：\n" %(i+1), map.get(i), "\n"

main()
































