package main;

public interface StackInterface {
    /**
     * Pushes an item onto the top of this stack
     * @param o object to push
     */
    public void push(Object o);
    
    /**
     *  Removes the object at the top of this stack and returns that object as the value of this function
     * @return the object at the top of this stack
     */
    public Object pop();
    
    /**
     * Looks at the object at the top of this stack without removing it from the stack
     * @return the object at the top of this stack
     */
    public Object peek();
    
    /**
     * Returnes the size of this stack
     * @return size of this stack
     */
    public int size();
    
    /**
     * Returns true if this stack is empty
     * @return true if this stack is empty and false if it is not empty
     */
    public boolean isEmpty();
}
