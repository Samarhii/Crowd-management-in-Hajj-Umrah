
package ds_projj;


public class stack<E> {
    private class Node<E>{
        private E code;
        private E name;
        private Node<E> next;

        public Node(E code, E name, Node<E> next) {
            this.code = code;
            this.name = name;
            this.next = next;
        }

        public E getCode() {
            return code;
        }

        public void setCode(E code) {
            this.code = code;
        }

        public E getName() {
            return name;
        }

        public void setName(E name) {
            this.name = name;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }   
    }//end of node class
    
    private Node<E> top=null;
    private int size=0;
    
    public boolean isEmpty(){
        return (size==0);
    }
    
    public int size(){
        return size;
    }
    
    public E top(){
        if(isEmpty()){
            System.out.println("There is no one im the mousqe!");
            return null;
        }
        return top.code;
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("There is no one im the mousqe!");
            return;
        }
        Node<E> current=top;
        while(current!=null){
            System.out.println("Name: "+top.getName() + "\nCode: "+ top.getCode());
            current=current.next;
        }
    }
    
    public void push(E name,E code){
        Node<E> newNode = new Node<E> (name,code,top);
        top=newNode;
        size++; 
    }
    
    public E pop(){
        if(isEmpty()){
            System.out.println("There is no one im the mousqe!");
            return null;
        }
        E temp=top.code;
        top= top.next;
        size--; 
        return temp;
    } 

}
