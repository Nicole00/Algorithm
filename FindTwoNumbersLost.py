#coding=utf-8
# @author Nicole
#问题描述：将1-100的数随机放入长度为98的数组中，求缺失的两个数字
import random

def findTwoNumbers(a):
    lostNumbers = []
    heap = {}
    #将heap初始化，heap的100个key对应的value初始为0
    for k in range(100):
        heap[k+1] = 0
    #如果key是98个数组中的一个元素，则将其value设为1
    for i in range(len(a)):
        heap[a[i]] = 1
    for key in heap:
        if heap[key] != 1:
            lostNumbers.append(key)
    return lostNumbers


def main():
    array = set()                               #为了防止随机生成的数重复，用set来存储98个随机数
    while len(array)<98:
        array.add(random.randint(1,100))
    print (sorted(array))                       #用于查看哪两个数缺失
    array1 = []
    for ele in array:                           #将set中的值放到数组中
        array1.append(ele)
    lostNumbers = findTwoNumbers(array1)

    for element in lostNumbers:
        print element

main()

