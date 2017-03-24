#!/user/bin/python
#coding=utf-8
#@author  Nicole

def BoundarySort(a,start, end):
    #选择一个基准位置key，一般选择数组第一个元素
    key = a[start]
    while(start < end):
        #如果最后位置的值比key大，则不动，只将end前移即可
        if(start < end and a[end] >= key ):                  #画外音：连接符一开始用的&....深中Java的毒，调试了一个小时死循环====囧
            end -= 1
        #如果最后位置的值比key小，则将其赋给start位置，start向后移动一位，并将新的start位置的值给end，令新start位置的值等于key
        if(start < end and a[end] < key):
            a[start] = a[end]
            start += 1
            a[end] = a[start]
            a[start] = key
    return start


def QuickSort(a,start,end):
    if start < end:
        index = BoundarySort(a,start,end)
        QuickSort(a,start,index)
        QuickSort(a,index+1,end)

def main():
    a=[7,2,4,5,6,8,0,1,12]
    print a
    QuickSort(a,0,len(a)-1)
    print a


main()