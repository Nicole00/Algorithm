#!/user/bin/python
#coding=utf-8
#@author  Nicole

#二分查找循环实现
def BinarySearch(a, k):
    low = 0
    high = len(a) - 1
    while(low <= high):
       mid = (low + high) / 2
       midval = a[mid]

       if (midval < k):
           low = mid + 1
       elif (midval > k):
           high = mid - 1
       elif (midval == k):
           return mid
    return -1


#二分查找递归实现
def BinSearch(a,low, high,k):

    mid = (low + high) / 2
    if low > high:
        return -1
    if a[mid] == k:
        return mid
    if a[mid] < k:
        low = mid + 1
    if a[mid] > k:
        high = mid -1
    return BinSearch(a,low,high,k)


def main():
    a = [1,5,3,9,7,2]

    #测试循环方法
    index0 = BinarySearch(a,7)
    value0 = a[index0]
    print index0, value0

    #测试递归方法
    low = 0
    high = len(a) - 1
    index1 = BinSearch(a,low,high,7)
    value1 = a[index1]
    print index1, value1


main()

