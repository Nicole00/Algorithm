#coding=utf-8
# @author Nicole
#问题描述：从一个二维数组中查找给定的值，二维数组中横向纵向都是递增序列。每次查找右上角的元素，如果要查找的key大于该位置的元素，则去掉该行
# 若小于该位置元素，则去掉该列。
#       1  2  3
#       4  5  6
#       7  8  9

def find(a,key):
    i = 0
    j = len(a[0])-1

    element = a[i][j]
    while i < len(a) and j >= 0:
        if element == key:
            return True
        elif element > key:
            j -= 1
        else:
            i += 1
        if i<len(a) and j>=0:
            element = a[i][j]
    return False

def main():
    # 初始化一个二维数组
    a = [[1,2,3], [4,5,6], [7,8,9]]
    print repr(find(a,12))

main()

