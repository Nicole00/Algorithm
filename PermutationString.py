#coding=utf-8
# @author Nicole
#问题描述： 对字符串进行全排列。 递归实现



def permutation(str,pBegin):
    if str == None:
        return
    if pBegin == len(str)-1:
        print str
    else:
        for i in range(pBegin,len(str)-1):
            str[i], str[pBegin] = str[pBegin], str[i]
            permutation(str, pBegin+1)
            str[i], str[pBegin] = str[pBegin], str[i]

def main():
    str = ['a','b','c','d','e','/n']
    permutation(str,0)

main()