import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

/**
 * create the class DequeCyclic of a type Element 
 * contains the following fields front, rear and count with the type int.
 */
public class DequeCyclic <E> implements Deque <E> {
    private E [] block;
    private int front;
    private int rear;
    private int count;

    public static void main(String[] args) {
        System.out.println("Hello");
    }

 @SuppressWarnings("unchecked") 

/**
 * create the constructor for DequeCyclic
 * @param size
 * intialize all the fields.
 */
public DequeCyclic (int size) { 
   block = (E[]) new Object[size];
     // asign values here
    front = 0;
    rear = 1;
    count=0;
}

/**
 * create a method to test if the deque is empty
 * false otherwise
 */
public boolean isEmpty() {
    if (count == 0) {
        return true;   
    } return false;
}

/**
 * create a method to test if the deque os full, 
 * false otherwise
 */
public boolean isFull() {
    if (count == block.length) {
        return true;
    } return false;
}

/**
 * add item to the right-most object in the deque
 * throw an Underflow exception if the deque is empty
 */
public void pushRight(E item) throws Overflow{
    if(isFull()) {
        throw new Overflow ("THE QUEUE IS FULL");
    } else {
        block[rear]= item;
        rear++;
        count++;
    }
    if(rear==block.length) {
        rear=0;
    }
}

/**
 * add item to the left-most object in the deque
 * throw overflow exception if the deque is full
 */

public void pushLeft(E item) throws Overflow {
    if(isFull()) {
        throw new Overflow ("THE QUEUE IS FULL");
    } else {
        block[front]= item;
        front--;
        count++;
    }
     if(front==-1){
         front=block.length-1;
     }
    }

/**
 * return the left-most object in the deque
 * throw an Underflow exception if the deque is empty 
 */
public E peekLeft() throws Underflow {
    E item;
    if(isEmpty()) {
        throw new Underflow ("THE QUEUE IS EMPTY");
    } 
    else{
    if(front==block.length-1) {
        return block[0];

    } 
    
    else {
        item= block[front + 1];
        return item;
    }
}
}

/**
 * return the right-most object in the deque 
 * throw an Underflow exception if the deque is empty 
 */
public E peekRight() throws Overflow {
    if(isEmpty()) {
        throw new Underflow ("THE QUEUE IS EMPTY");
    } else {
        if (rear==0) {
            return block[block.length-1];
        }
        return block[rear - 1];
    }
}

/**
 * remove and return the left-most object in the deque
 * throw an underflow exception if the deque is empty 
 */
public E popLeft() throws Underflow {
    E item;
    if (isEmpty()) {
        throw new Underflow ("THE QUEUE IS EMPTY");
    }
    else {
    if(front==block.length-1) {
        front=0;
    }
    else {
        front++;
    }
    item = block[front];
    block[front]=null;
    count--;
    return item;
    }
}

/**
 * remove and retun the right-most object in the deque
 * throw an underflow exception if the deque is empty
 */
public E popRight() throws Underflow {
    E item;
    if (isEmpty()) {
        throw new Underflow ("THE QUEUE IS EMPTY");
    }
    else {
    if(rear==0) {
        rear= block.length-1;
    }
    else{
        rear--;
    }
        item = block[rear];
        block[rear]=null;
        count--;
        return item;
}
}

}
 