#coding=utf-8
# @author Nicole
#问题描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
#要求时间复杂度是O(n)，空间复杂度是O(1)。         思路：位操作。

import math

#将数组中所有元素进行异或，求出最后结果中从低位开始第一个为1的位置。（从0开始）
def findIndexOfFirst1(a):
    result = 0
    for i in a:
        result = result ^ i
    index = 0
    for j in range (len(str(bin(result)))):
        if (result & pow(2,j)):
            index = j
            break
    return index


#根据result中第一个为1的位置为第N位，将数组中元素根据第N位是1还是0分成两个子数组，则只出现1次的两个元素分别位于两个子数组中。
def divideNumberIntoTwoArray(a,n):
    array0 = []           #存储第N位为0的元素
    array1 = []           #存储第N位为1的元素

    for element in a:
        if (element & pow(2,n)):
            array1.append(element)
        if not (element & pow(2,n)):
            array0.append(element)
    return array0, array1


#从数组中找出只出现一次的一个数字，其他数字均出现两次
def findOneNumberInArray(a):
    value = 0
    for key in a:
        value = value ^ key
    return value


def main():
    a = [3,5,7,8,9,1,3,7,9,5,6,1]
    indexOfFirst1 = findIndexOfFirst1(a)
    array0, array1 = divideNumberIntoTwoArray(a,indexOfFirst1)
    value1 = findOneNumberInArray(array0)
    value2 = findOneNumberInArray(array1)
    print value1, value2

main()