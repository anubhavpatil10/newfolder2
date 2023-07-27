package sorting;

class Customer {
    private String name;
    private int age;
    private String email;
    private Customer prev; 
    private Customer next; 

    public Customer(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.prev = null;
        this.next = null;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getPrev() {
        return prev;
    }

    public void setPrev(Customer prev) {
        this.prev = prev;
    }

    public Customer getNext() {
        return next;
    }

    public void setNext(Customer next) {
        this.next = next;
    }
}

class DoublyLinkedList {
    private Customer head; 
    private Customer tail; 

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addCustomer(Customer customer) {
        if (head == null) { 
            head = customer;
            tail = customer;
        } else {
            customer.setPrev(tail);
            tail.setNext(customer);
            tail = customer;
        }
    }

    public void displayCustomers() {
        Customer current = head;
        while (current != null) {
            System.out.println("Name: " + current.getName() + ", Age: " + current.getAge() + ", Email: " + current.getEmail());
            current = current.getNext();
        }
    }

    public Customer searchCustomerByName(String name) {
        Customer current = head;
        while (current != null) {
            if (current.getName().equals(name)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void removeCustomer(Customer customer) {
        if (customer == null) {
            return;
        }
        if (customer.getPrev() != null) {
            customer.getPrev().setNext(customer.getNext());
        } else {
            head = customer.getNext();
        }
        if (customer.getNext() != null) {
            customer.getNext().setPrev(customer.getPrev());
        } else {
            tail = customer.getPrev();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        DoublyLinkedList customerList = new DoublyLinkedList();

        
        customerList.addCustomer(new Customer("Alice", 25, "alice@example.com"));
        customerList.addCustomer(new Customer("Bob", 30, "bob@example.com"));
        customerList.addCustomer(new Customer("Charlie", 22, "charlie@example.com"));

     
        customerList.displayCustomers();
    }
}
