#coding=utf-8
# @author Nicole
#问题描述：在旋转数组中查找最小元素，时间复杂度小于O(n)

#根据给定的长度进行旋转数组
def rotateArray(a,k):
    if len(a) < k or k < 0:
        print "invalid position"
        return
    if len(a) == k or k == 0:
        return a
    temp = []
    for i in range(k):
        temp.append(a[i])
    for j in range(len(a) - k):
         a[j] = a[j+k]
    for g in range(k):
        a[len(a)-k+g] = temp[g]
    print a
    return a


# a=[1,2,3,4,5,6,7,8]
# rotateArray(a,4)

#对旋转数组进行二分查找
def search(a,low, high):
    if low >= high:
        print "invalid input"
    mid = (low + high) / 2
    if low == high-1:
        return a[high]
    if a[mid] > a[0]:
        return search(a, mid, high)
    if a[mid] < a[-1]:
        return search(a,low, mid)


def main():
    a = [1,2,3,4,5,6,7,8]
    k = 2
    rotateA = rotateArray(a,k)
    result = search(rotateA,0,len(rotateA))
    print result


main()