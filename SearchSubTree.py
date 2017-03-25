#coding=utf-8
#@author Nicole

#定义树的节点（用二叉链表表示）
class Node:
    leftChild = None
    rightChild = None
    def __init__(self,value=None,left=None,right=None):
        self.value = value
        self.leftChild = left
        self.rightChild = right

#当两颗树的root值相同时递归判断B树是否是A树的子结构
def TreeA_Has_TreeB(TreeA, TreeB):
    if TreeB == None:
        return True
    if TreeA == None:
        return False
    if TreeA.value != TreeB.value:
        return False
    return TreeA_Has_TreeB(TreeA.leftChild, TreeB.leftChild) and TreeA_Has_TreeB(TreeA.rightChild, TreeB.rightChild)

#比较B树是否是A树的子结构
def TreeBinTreeA(TreeA, TreeB):
    result = False
    if TreeB != None and TreeA != None:

        if TreeA.value == TreeB.value:
            result = TreeA_Has_TreeB(TreeA, TreeB)
        if result == False:
            result = TreeBinTreeA(TreeA.leftChild, TreeB)
        if result == False:
            TreeBinTreeA(TreeA.rightChild, TreeB)
    return result

#构造TreeA和TreeB
#  TreeA          8                             TreeB    8
#            8          3                             7     6
#        7     6
#     1
nodesA = [Node(8), Node(8), Node(3), Node(7), Node(6), Node(1)]
treeA = nodesA[0]
nodesA[0].leftChild = nodesA[1]
nodesA[0].rightChild = nodesA[2]
nodesA[1].leftChild = nodesA[3]
nodesA[1].rightChild = nodesA[4]
nodesA[3].leftChild = nodesA[5]

nodesB = [Node(8), Node(7), Node(6)]
treeB = nodesB[0]
nodesB[0].leftChild = nodesB[1]
nodesB[0].rightChild = nodesB[2]

print repr(TreeBinTreeA(treeA, treeB))
