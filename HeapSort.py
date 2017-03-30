#coding=utf-8
# @author Nicole

#下移节点。   我写的这个比较左右孩子的方法太幼稚了====
def sift_down1(a,cur_pos,length):
    #确定当前节点cur_pos的左右孩子的下标
    left = cur_pos * 2 + 1
    right = cur_pos * 2 + 2

    temp= a[cur_pos]

    #当前位置为叶节点时停止下移
    if left >= length and right >= length:
        return
    #当前节点只有左孩子且比左孩子小时，交换
    elif left < length and right >= length:
        if a[cur_pos] < a[left]:
            a[cur_pos], a[left] = a[left], a[cur_pos]
            cur_pos = left
        else:
            return
    #当前节点拥有左孩子和右孩子
    elif left < length and right <length:
        if a[cur_pos] >= a[left]:
            if a[cur_pos] >= a[right]:              #当前节点比左孩子大，比右孩子也大
                return
            else:                                   #当前节点比左孩子大，比右孩子小，与右孩子交换
                a[cur_pos], a[right] = a[right], a[cur_pos]
                cur_pos = right
        else:
            if a[cur_pos] >= a[right]:               #当前节点比左孩子小，比右孩子大，与左孩子交换
                a[cur_pos], a[left] = a[left], a[cur_pos]
                cur_pos = left
            else:                                    #当前节点比左孩子小，比右孩子也小，则与其中两个较大者交换
                if a[left] >= a[right]:
                    a[cur_pos], a[left] = a[left], a[cur_pos]
                    cur_pos = left
                else:
                    a[cur_pos], a[right] = a[right], a[cur_pos]
                    cur_pos = right
    return sift_down(a,cur_pos,length)



#下移节点。 这个比较左右孩子的方法简洁
def sift_down(a,cur_pos, length):
    # 确定当前节点cur_pos的左右孩子的下标
    left = cur_pos * 2 + 1
    right = cur_pos * 2 + 2

    larger = cur_pos

    if left < length and a[left] > a[cur_pos]:
        larger = left
    if right < length and a[right] > a[larger]:
        larger = right
    if larger != cur_pos:
        a[larger], a[cur_pos] = a[cur_pos], a[larger]
        sift_down(a,larger, length)


#建堆
def build_head(a):
    length = len(a)
    #最后一个内节点
    last_inner = length / 2 - 1

    while last_inner >= 0:
        sift_down(a,last_inner,length)
        last_inner -= 1

    return a


#堆排序，每次将最大堆的堆顶元素放到当前数组的最后面
def sort_heap(a):
    x = len(a) - 1
    while(x > 0):
        a[x], a[0] = a[0], a[x]
        sift_down(a, 0, x)
        x -= 1
    return a


def main():
    a = [2,3,0,4,9,8,7,5,6,1]
    heap_a = build_head(a)
    sort_a = sort_heap(heap_a)
    for i in a:
        print i,

main()