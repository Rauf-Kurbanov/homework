package main;

public interface StackInterface {
    /**
     * Pushes an item onto the top of this stack
     * @param o 
     */
    public void push(Object o);
    
    /**
     *  Removes the object at the top of this stack and returns that object as the value of this function
     * @return 
     */
    public Object pop();
    
    /**
     * Looks at the object at the top of this stack without removing it from the stack
     * @return 
     */
    public Object peek();
    
    /**
     * Returnes the size of this stack
     * @return 
     */
    public int size();
    
    /**
     * Returns true if this stack is empty
     * @return 
     */
    public boolean isEmpty();
}
