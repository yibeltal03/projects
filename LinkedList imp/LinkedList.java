import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    // created private variable "len" to keep track of size of array
    Node head;
    private boolean isSorted;
    private int len;

    public LinkedList(){
        len = 0;
       head = null;
       isSorted = true;
    }


    public boolean add(T element) {

        if (head != null) {


            Node a;
            Node current = head;
            if (element == null) {
                return false;
            } else {

                a = new Node(element, null);
                while (current.getNext() != null) {

                    current = current.getNext();
                }
                current.setNext(a);
                isSorted = false;
                len++;
                return true;
            }
        }

        else{
            if (element == null){
                return false;
            }
            else {
                isSorted = false;
                head = new Node(element);
                len++;
                return true;
            }
        }
    }


    /*
     *  Add an element at specific index. This method should
     * also shift the element currently at that position (if
     * any) and any subsequent elements to the right (adds
     * one to their indices). If element is null, or if index
     * index is out-of-bounds (index < 0 or index >= size_of_list),
     * it will NOT add it and return false. Otherwise it will
     * add it and return true. See size() for the definition
     * of size of list. Also updates isSorted variable to false.
     */
    public boolean add(int index, T element) {
        int n = 0;



        Node a = new Node(element);
        Node current = head;

        if (element != null && index < len && index >= 0 ) {

            if (index == 0){

                Node set1 = new Node(element);
                 set1.setNext(head);
                 head = set1;
                isSorted = false;


                return true;
            }

            while (n < index-1 && current != null) {
                current = current.getNext();
                n++;
            }

                    a.setNext(current.getNext());
                    current.setNext(a);
                    len++;
                    isSorted = false;

                    return true;


        }



        return false;

    }

    /*
     * Remove all elements from the list.
     */
    public void clear() {
       head = null;
       len = 0;
    }

    /*
     * Return true if element is in the list and false
     * otherwise. If isSorted is true, uses the ordering
     * of the list to increase the efficiency of the search.
     */
    public boolean contains(T element){
        Node current = head;
         while(current != null && element != null) {

             if (element.equals(current.getData())) {
                 return true;
             }
             current = current.getNext();
         }

            return false;


    }

    /*
     *  Return the element at given index. If index is
     * out-of-bounds, it will return null.
     *
     */
    public T get(int index){
        int n = 0;

        if (index >= len || index < 0){
            return null;
        }

        else {
            Node<T> current = head;
            while (n < index) {
                current = current.getNext();
                n++;
            }
            return current.getData();
        }

    }

    /*
     * Return the first index of element in the list. If element
     * is null or not found in the list, return -1. If isSorted is
     * true, uses the ordering of the list to increase the efficiency
     * of the search.
     */
    public int indexOf(T element){
        int a = 0;
        if (element != null){
        Node current = head;

        while(current != null) {

            int x = current.getData().compareTo(element);
            System.out.println(current.getData());
            if (x == 0) {
                return a;
            }
            a++;
            current = current.getNext();
        }


    }
        return -1;
    }

    /*
     * Return true if the list is empty and false otherwise.
     */
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * Same as indexOf(), except it will return the last index
     * of element. If isSorted is true, uses the ordering
     * of the list to increase the efficiency of the search.
     */
    public int lastIndexOf(T element){
        Node current = head;
        int count= 0;
        int count2 = -1;

        if (element != null) {
            while (current != null) {

                int comp =current.getData().compareTo(element);
                //System.out.println(comp);
                //System.out.println(count2);
                if (comp == 0) {
                   count2 = count;
                }
                count++;

                current = current.getNext();

            }
            return count2;
            }
        return -1;

    }

    /*
     * Replace the element at index with element and return the
     * element that was previously at index. If index is
     * out-of-bounds or element is null, do nothing with element
     * and return null.
     */
    public T set(int index, T element){
        int n = 0;
        Node current = head;
        if (index < len && element != null && index >= 0) {

            while (n < index) {

                current = current.getNext();
                n++;
            }
            T copy =(T) current.getData();

            current.setData(element);
            isSorted = false;

            return copy;
        }
        return null;

    }

    /*
     * Return the number of elements in the list. For example, if
     * 4 elements added to a list, size will return 4, while the
     * last index in the list will be 3.
     */
    public int size(){
        return len;
    }

    /*
     * Sort the elements of the list. If order is true, sort the
     * list in increasing (alphabeticaly) order. If order is
     * false, sort the list in decreasing (reverse alphabetical)
     * order. Note: only set isSorted to true if sorted in ASCENDING
     * order.
     * If isSorted is true, and the order is true, do NOT resort.
     * Hint: Since T extends Comparable, you will find it useful
     * to use the public int compareTo(T o) method.
     */
    public void sort(boolean order) {

        if (len > 1 && isSorted != true) {
            Node current = head;


            if (order == true) {
                int i = 0;

                Node<T> next1 = current;

                while(i < len-1) {
                    int j = 0;
                    next1 = current;
                    while (j < len- i- 1) {


                        T currNum = (T) next1.getData();
                        T nextNum = (T) next1.getNext().getData();

                        System.out.println(currNum.compareTo(nextNum));
                        if (currNum.compareTo(nextNum) > 0) {

                            // T temp = currNum;
                            // T temp2 = nextNum;
                            set(j, nextNum);
                            set(j + 1, currNum);

                        }
                        next1 = next1.getNext();
                        j++;

                        //current = current.getNext();


                    }
                    i++;
                }
                isSorted = true;
            }
                //return next1;




         else {
                    int i = 0;
                    while(i < len) {
                        Node<T> next1 = current;
                        int j = 0;
                        while (j < len - 1) {

                            T currNum = (T) next1.getData();
                            T nextNum = (T) next1.getNext().getData();

                            //System.out.println(current.toString());
                            if (currNum.compareTo(nextNum) < 0) {

                                // T temp = currNum;
                                // T temp2 = nextNum;
                                set(j, nextNum);
                                set(j + 1, currNum);

                            }
                            next1 = next1.getNext();

                            //current = current.getNext();

                            j++;

                        }
                        i++;
                    }
                isSorted = true;
                }

            }



    }

    /*
     * Remove the first instance of element from the list. This
     * method should also shifts any subsequent elements to the
     * left (subtracts one from their indices). If successful,
     * return true. If element is not found in the list, return
     * false.
     *
     */
    public boolean remove(T element) {
        Node current = head;
        if (current.getData().equals(element)) {
            head = head.getNext();
            isSorted = false;
            len--;
            return true;
        } else {
           Node<T> prev = head;
            while (current != null) {

                if (current.getData().equals(element)) {
                    prev.setNext(prev.getNext().getNext());
                    isSorted = false;
                    len--;
                    return true;
                }
                prev = current;
                current = current.getNext();

            }



        }
        return false;
    }

    /*
     * Remove whatever is at index index in the list and return
     * it. If index is out-of-bounds, return null. Shift the
     * indices as in the other remove.
     */
    public T remove(int index){

    int n = 0;
    Node current = head;
    if (index == 0) {
        T temp = (T) current.getData();
        head = head.getNext();
        isSorted = false;
        len--;
        return temp;
    }
    else {
        int x;
        //current = current.getNext();
        Node<T> prev = current;
        while (n <= index && current != null) {


            if (n == index) {
                T temp = (T) current.getData();
                prev.setNext(prev.getNext().getNext());
                isSorted = false;
                len--;

                return temp;
            }
            n++;

            prev = current;
            current = current.getNext();

        }
    }
       return null;
}



    public String toString(){
        Node current = head;
        String st = "";

        while(current != null && current.getData() != null){
            st += current.getData() + " ";
            current = current.getNext();
        }

        return st;
    }

    /*
     * Note that this method exists for debugging purposes.
     * It calls the toString method of the underlying elements in
     * the list in order to create a String representation of the list.
     * The format of the toString should appear as follows:
     * Element1
     * Element2
     * .
     * .
     * .
     * Elementn
     * Watch out for extra spaces or carriage returns. Each element
     * should be printed on its own line.

     */
    public static void main(String[] args){
        LinkedList t = new LinkedList();
        LinkedList b = new LinkedList();
        t.add("cat");
        t.add("dog");
        t.add("snake");



        b.add("cat");
        b.add("dog");
        b.add("snake");

        //b.add(0,"fish");
        System.out.println(b);
        System.out.println(b.remove(1));
        System.out.println(b);
       // System.out.println(b.remove(1));
        System.out.println(b);

        System.out.println(b.get(1));
        //System.out.println(b.get(1));




       // System.out.println(b.get(1));


        //b.remove("dog");





        //System.out.println(t.indexOf("d"));
        //System.out.println(b.set(0,"dog"));



    }
}

