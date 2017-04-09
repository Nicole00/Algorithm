#coding=utf-8
# @author Nicole
#问题描述：打印1到最大的n位数。（考虑大数溢出情况，用字符串表示大数）

def print1ToMaxOfNDigits(n):
    if n <= 0:
        return
    array = [0 for x in range(n)]
    while Increment(array) is False:
        printer(array)


#判断是否到达最大的n位数
def Increment(strs):
    isOverflow = False
    nTakeOver = 0       #记录进位
    nlen = len(strs)
    for i in range(nlen-1, -1, -1):   #按数组倒序循环
        nSum = strs[i] + nTakeOver
        if i == nlen-1:
            nSum += 1
        if nSum >= 10:
            if i == 0:
                isOverflow = True
            else:
                nSum -= 10
                nTakeOver = 1
                strs[i] = nSum
        else:
            strs[i] = nSum
            break
    return isOverflow



def printer(strs):
    isBegining0 = True
    nlen = len(strs)
    for i in range(nlen):
        if (isBegining0 and strs[i] != 0):  #判断前面为0则不打印，从第一个为1的值开始打印
            isBegining0 = False
        if isBegining0 is False:
            print strs[i],
    print "   "


print1ToMaxOfNDigits(3)