#coding=utf-8
#@author Nicole

#给定一个集合，求出该集合的所有子集。转换成01序列，0表示没有选中该位置的元素，1表示选中了该位置的元素。
def subSet(set):
    length = len(set)
    for i in range(0,pow(2,length)):
        setStr = str(bin(i))
        unchoose = length - len(setStr)
        print "{",

        for j in range(0,len(setStr)):
            if setStr[j] == "1":
                print set[unchoose+j],

        print "}"

def main():
    str = raw_input()
    set = str.split(",")
    subSet(set)

main()