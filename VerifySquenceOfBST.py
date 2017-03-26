#coding=utf-8
#该题目给定一个整数数组，判断该数组是否为某二叉搜索树的后序遍历结果，数组中无重复元素。递归思想
#@author Nicole

def VerifySquenceOfBST(squence, length):
     # 判定边界情况
    if squence is None or length <= 0:
        return False
     #在后序遍历序列中，最后一个元素一定是树的根
    root = squence[length-1]

    #判断左子树对应的序列
    i = 0
    for i in range(0, length-1):
         if squence[i] > root:
             break

    #左子树序列后面的序列就是右子树，如果右子树序列中存在比root小的元素，则不符合二叉搜索树的规则，返回False
    j = i
    for j in range(i,length-1):
         if squence[j] < root:
             return False

    #判断左子树序列是否是二叉搜索树
    left = True
    if i > 0:
         left = VerifySquenceOfBST(squence, i)

    #判断右子树序列是否是二叉搜索树
    right = True
    if i < length-1:
        right = VerifySquenceOfBST(squence[i:length-1], length - 1 - i)       #强大的python，squence[i:length-1]就实现了下面四行代码，取第i到第length-1个元素作为新list
        #sub_squence = []
        #for k in range(i,length):
            #sub_squence.append(squence[k])
        #right = VerifySquenceOfBST(sub_squence, length-1-i)

    return (left and right)


def main():
    #接收用户的输入,转换成int类型数组
    squen = []
    str = raw_input()
    squen = str.split(",")
    for i in range(0,len(squen)):
        squen[i] = int(squen[i])

    #调用VerifySquenceOfBST函数
    bool = VerifySquenceOfBST(squen,len(squen))
    print bool


main()