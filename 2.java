import java.util.*;
public class CircularLinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;


    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; 
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; 
        }
    }

    public int sumEvenNumbers() {
        if (head == null) return 0;

        int sum = 0;
        Node current = head;

        do {
            if (current.data % 2 == 0) {
                sum += current.data;
            }
            current = current.next;
        } while(current != head);

        return sum;
    }
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.print("Circular linked list: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println(head.data);
    }
    
   public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.println("Circular Linked List Input");
        System.out.println("Enter numbers to add to the list (Enter e to stop):");

        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            list.add(val);
        }

        System.out.println("\nInput complete.");
        list.display();
        System.out.println("Sum of even numbers: " + list.sumEvenNumbers());
        
        sc.close();
    }
}
