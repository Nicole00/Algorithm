#coding=utf-8
# @author Nicole         用链表实现快排

class Node:
    def __init__(self,data,next=None):
        self.data = data
        self.next = next

def sort(head, end):
    if (head == None or head == end):
        return
    p = head.next
    small = head
    while p is not None:
        if p.data < head.data:
            small = small.next
            p.data, small.data = small.data, p.data
        p = p.next
    head.data, small.data = small.data, head.data
    sort(head, small)
    sort(small.next, end)

def main():
    node1 = Node(5)
    node2 = Node(2)
    node3 = Node(9)
    node4 = Node(1)
    node5 = Node(3)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    sort(node1,node5)
    print node1.data, node2.data, node3.data, node4.data, node5.data

main()
