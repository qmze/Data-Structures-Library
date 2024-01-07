class DoublyLinkedNode<T> {
    T data;
    DoublyLinkedNode<T> next;
    DoublyLinkedNode<T> prev;

    public DoublyLinkedNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class HumanFriendlyDataStructures<T> {
    private DoublyLinkedNode<T> firstNode;
    private DoublyLinkedNode<T> lastNode;

    public HumanFriendlyDataStructures() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public void add(T data) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(data);
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.prev = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    public void displayForward() {
        DoublyLinkedNode<T> current = firstNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        DoublyLinkedNode<T> current = lastNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = lastNode.data;
        lastNode = lastNode.prev;
        if (lastNode != null) {
            lastNode.next = null;
        } else {
            firstNode = null;
        }
        return data;
    }

    public static void main(String[] args) {
        HumanFriendlyDataStructures<Integer> dataStructures = new HumanFriendlyDataStructures<>();
        dataStructures.add(1);
        dataStructures.add(2);
        dataStructures.add(3);

        System.out.print("Doubly-Linked List Forward: ");
        dataStructures.displayForward();

        System.out.print("Doubly-Linked List Backward: ");
        dataStructures.displayBackward();

        System.out.println("Popped element from the stack: " + dataStructures.pop());
    }
}
