import CITS2200.Stack;
import CITS2200.Overflow;
import CITS2200.Underflow;

/**
 * create a class called stack 
 * acts as a last in, first out (LIFO) 
 * access to the elements is via the top of the stack
 */

public class StackBlock implements Stack {
    private Object[] block;
    private int top = -1;

    /**
     * create the constructor
     * create an empty stac
     * @param size
     */
     
    public StackBlock(int size) {
    block = new Object [size]; 
    }

    /**
     * 
     * @return true if the stack is empty, false otherwise 
     */

    public boolean isEmpty() {
      if(top == -1) {
          return true;
      } return false;

    }

    /**
     * 
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        if(top == block.length-1) {
            return true;
        } return false;
    }

    /**
     * push obect item onto the top if the stack
     * throw an overflow exception if the stack is full
     * @param item
     * @throws Overflow
     */

    public void push(Object item) throws Overflow{
       if(isFull()) {
           throw new Overflow("THE STACK IS FULL");
        } else {
            top++;
            block[top]= item;
        }   
     }

    /**
     * 
     * @return the object on top of the stack
     * throw an underflow exception if the stack is empty
     */

    public Object examine() {
        if (!isEmpty()) {
            return block [top];
        }
        throw new Underflow("THE STACK IS EMPTY");
    }

    /**
     * 
     * @return the object on top of the stack
     * @throws Underflow if the stack is empty
     */

    public Object pop() throws Underflow {
        Object item;

        if (!isEmpty()) {
            item = block[top];
            top--;
            return item;

        }
        throw new Underflow("THE STACK IS EMPTY");

    }

    }

    