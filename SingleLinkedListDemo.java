
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(listNode4);
        singleLinkedList.addByOrder(listNode1);
        singleLinkedList.addByOrder(listNode2);
        singleLinkedList.addByOrder(listNode5);
        singleLinkedList.addByOrder(listNode3);
        singleLinkedList.addByOrder(listNode6);
        singleLinkedList.list();
        System.out.println("singleLinkedList节点数为---" + singleLinkedList.getLenth(singleLinkedList.getHeadNode()));
        ListNode lastIndexNode = singleLinkedList.findLastIndexNode(singleLinkedList.getHeadNode(), 1);
        System.out.println("singleLinkedList倒数第K个节点为-------" + lastIndexNode);

        System.out.println("singleLinkedLi单链表反转后的节点为-------");
        singleLinkedList.reverseList(singleLinkedList.getHeadNode());
        singleLinkedList.list();

          // 创建链表 1 -> 2 -> 3 -> 4
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    // 反转链表

    ListNode reversed = singleLinkedList.reverseList2(node1);

    // 打印反转后的链表
    singleLinkedList.list();
    }

}

// 定义一个Node类，没一个Node类就是一个节点
class ListNode {
    public int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + "]";
    }
}

class SingleLinkedList {

    public ListNode getHeadNode() {
        return headNode;
    }

    // 先初始化一个头节点，头结点不要动，不存放具体数据
    ListNode headNode = new ListNode(0);

    // 添加节点到单向链表
    // 思路，当不考虑编号顺序时
    // 1。找到当前链表的最后节点
    // 2. 将最后节点的next指针，指向新的节点
    public void add(ListNode newNode) {
        // 因为head节点不能动，所以需要一个辅助遍历指针temp
        ListNode temp = headNode;
        // 遍历链表
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 没有找到就后移
            temp = temp.next;
        }
        // 当退出while循环时，说明已经找到最后的节点
        // 将最后节点的next指向新的节点
        temp.next = newNode;
    }
    // 遍历链表

    public void list() {
        // 判断链表是否为空
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = headNode.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void addByOrder(ListNode newListNode) {
        ListNode temp = headNode;
        // flag 判断添加的节点是否已经存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) { // 说明temp已经在链表的最后
                break;
            }
            if (temp.next.val > newListNode.val) {
                break;
            } else if (temp.next.val == newListNode.val) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            System.out.println("该节点已经存在，不能加入");

        } else {
            newListNode.next = temp.next;
            temp.next = newListNode;
        }
    }

    public void delete(int val) {
        ListNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.val == val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        }
    }

    public int getLenth(ListNode headNode) {
        if (headNode.next == null) {
            return 0;
        }
        int lenth = 0;
        ListNode cur = headNode.next;
        while (cur != null) {
            lenth++;
            cur = cur.next;
        }
        return lenth;
    }

    public ListNode findLastIndexNode(ListNode headNode, int index) {
        if (headNode.next == null) {
            return null;
        }
        int size = getLenth(headNode);
        if (index < 0 || index > size) {
            return null;
        }
        ListNode cur = headNode.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void reverseList(ListNode headNode) {
        // 如果只有一个节点，或者只有头结点，那么直接返回为空
        if (headNode.next == null || headNode.next.next == null) {
            return;
        }
        // 定义一个辅助指针，遍历链表
        ListNode cur = headNode.next;
        ListNode next = null;// 指向当前节点的下一个节点
        ListNode reverseHeadNode = new ListNode(0);
        while (cur != null) {
            next = cur.next;// 保存当前节点的下一个节点，为了遍历
            cur.next = reverseHeadNode.next;
            reverseHeadNode.next = cur;
            cur = next;

        }
        headNode.next = reverseHeadNode.next;

    }
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null; // 初始化pre指针
        ListNode cur = head; // 初始化cur指针
        while (cur != null) { // 当前节点不为空时
            ListNode nxt = cur.next; // 保存当前节点的下一个节点
            cur.next = pre; // 当前节点的next指针指向前驱节点
            pre = cur; // 更新pre指针
            cur = nxt; // 更新cur指针
        }
        return pre; // 返回反转后的链表的头节点

    }
}
