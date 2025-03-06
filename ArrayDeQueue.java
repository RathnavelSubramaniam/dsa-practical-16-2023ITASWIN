import java.util.Scanner;

public class ArrayDeQueue {
    protected int capacity;
    protected int[] queue;
    protected int front = -1;
    protected int rear = -1;

    // Constructor to initialize queue
    public ArrayDeQueue(int cap) {
        capacity = cap;
        queue = new int[capacity];
    }

    // Returns the current size of the queue
    public int size() {
        return (rear - front);
    }

    // Adds an element to the queue
    public void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Overflow. Not possible to insert in Full Queue");
        } else {
            if (front == -1) {  // First element to insert
                front = 0;
            }
            queue[++rear] = data;
            System.out.println("Element inserted: " + data);
        }
    }

    // Checks if the queue is full
    public boolean isFull() {
        return (size() == capacity);
    }

    // Removes an element from the front of the queue
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Underflow. No elements to dequeue");
            return -1;  // return -1 indicating an empty queue
        } else {
            int dequeuedElement = queue[front];
            front++;  // Move the front index
            if (front > rear) {  // Reset to initial state if queue is empty after dequeue
                front = rear = -1;
            }
            return dequeuedElement;
        }
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return (front == -1 || front > rear);
    }

    // Displays all the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Underflow. No elements to display in Empty Queue");
        } else {
            System.out.println("Queue Elements:");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int data, n;
        char ch;
        Scanner sc = new Scanner(System.in);

        System.out.println("DeQueue Using Array");
        System.out.print("Enter the number of elements to be inserted: ");
        n = sc.nextInt();

        ArrayDeQueue q = new ArrayDeQueue(n);
        System.out.println("Queue Using Array created with size " + n);

        // Inserting elements into the queue
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            data = sc.nextInt();
            q.enQueue(data);
        }

        q.display();

        // Asking the user if they want to dequeue
        System.out.print("Do you want to Dequeue the Queue (y/n): ");
        ch = sc.next().charAt(0);

        while (ch == 'y' || ch == 'Y') {
            int dequeuedElement = q.deQueue();
            if (dequeuedElement != -1) {
                System.out.println("Dequeued Element: " + dequeuedElement);
            }
            q.display();

            System.out.print("Do you want to Dequeue again (y/n): ");
            ch = sc.next().charAt(0);
        }
    }
}