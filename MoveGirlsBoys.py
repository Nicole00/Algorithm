#coding=utf-8
# @author Nicole

#将男孩女孩分别用0,1表示后 他们的移动就转换成了冒泡排序
def move1(quen):
    #男孩都聚集在左边的情况
    count1 = 0
    for i in range(len(quen)):
        for j in range(1,len(quen)):
            if quen[j] < quen[j-1]:
                temp = quen[j-1]
                quen[j-1] = quen[j]
                quen[j] = temp
                count1 += 1
    return count1
def move2(quen):
    # 男孩都聚集在右边的情况
    count2 = 0
    for i in range(len(quen)):
        for j in range(1, len(quen)):
            if quen[j] > quen[j - 1]:
                temp = quen[j - 1]
                quen[j - 1] = quen[j]
                quen[j] = temp
                count2 += 1
    return count2





def main():
    kids = raw_input()
    i = 0
    squen1 = []
    squen2 = []
    for char in kids:
        if char == "G":
            squen1.append(1)
            squen2.append(1)
        elif char == "B":
            squen1.append(0)
            squen2.append(0)



    count1 = move1(squen1)
    count2 = move2(squen2)
    if count1 < count2:
        print count1
    else:
        print count2


main()



