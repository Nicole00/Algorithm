#coding=utf-8
#@author Nicole
class Node:
    def __init__(self,nodeData,node=None):
        self.nodeData = nodeData
        self.next = node

def merge(node1,node2):
    #判断两个链表是否为空，若有一个为空则直接返回另一个
    if node1 == None:
        return node2
    elif node2 == None:
        return node1
    #定义一个新链表，存放合并之后的节点们
    mergeNode = Node(None)

    #递归思想，每次都只比较两个链表的头节点
    if node1.nodeData < node2.nodeData:
        mergeNode.nodeData = node1.nodeData
        mergeNode.next = merge(node1.next,node2)
    else:
        mergeNode.nodeData = node2.nodeData
        mergeNode.next = merge(node1, node2.next)

    return mergeNode

#写个测试用例
def main():
    head1 = Node(1)
    head2 = Node(2)
    p1 = head1
    p2 = head2
    #生成测试用例head1=[1,3,5,7,9,11]    head2=[2,4,6,8,10,12]
    for i in range(5):
        p1.next = Node(3 + i * 2)
        p2.next = Node(4 + i * 2)
        p1 = p1.next
        p2 = p2.next

    mergeNode = merge(head1, head2)
    q = mergeNode
    #打印出合并后的链表
    while q:
        print q.nodeData
        q = q.next

main()



