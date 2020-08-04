import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class ArrayList<T extends Comparable<T>> implements List<T> {

    // created private variable "len" to keep track of size of array
    T[] a;
    boolean isSorted;
    private int len;

    public ArrayList(){
        a= (T[]) new Comparable[2];
        isSorted = true;
        len = 0;
    }
    public  T[] addArr( T[] newArr){
        newArr = (T[]) new Comparable[newArr.length*2];
        for (int x = 0; x< a.length;x++){
            newArr[x] = a[x];
        }
        return newArr;
    }

    /*
     * Add an element to end of the list. If element is null,
     * it will NOT add it and return false.  Otherwise, it
     * will add it and return true. Updates isSorted to false.
     */
    public boolean add(T element) {
        System.out.println(len);

        if (element != null) {
            if (len < a.length) {
                System.out.println(element);
                a[len] = element;
                len++;
                isSorted = false;
                return true;

            }

            else if (len == a.length) {

                int b = a.length;
                a = addArr(a);
                len ++;
                a[b] = element;

                return true;
            }
        }
        return false;
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
        System.out.println(len);
        if (element == null || index < 0 || index >= len || a[index] == null) {
            return false;

        }
            else {
            System.out.println(index + " " + a.length);
            if (a[a.length - 1] != null) {
                a = addArr(a);

            }


            if (a[index] == null) {
                a[index] = element;
                len++;
                return true;
            }

            for (int x = a.length - 1; x > index; x--) {
                a[x] = a[x - 1];
            }

            a[index] = element;
            len++;
            return true;

        }

                }




    /*
     * Remove all elements from the list.
     */
    public void clear(){
        for(int x = 0; x < a.length; x++){
            a[x] = null;
            len = 0;
        }
    }

    /*
     * Return true if element is in the list and false
     * otherwise. If isSorted is true, uses the ordering
     * of the list to increase the efficiency of the search.
     */
    public boolean contains(T element){
        if (element != null) {
            for (int x = 0; x < a.length; x++) {

                if(a[x] == null) {
                    return false;
                }
                if (a[x].equals(element)) {
                    return true;
                }


            }
        }
        return false;
    }

    /*
     *  Return the element at given index. If index is
     * out-of-bounds, it will return null.
     *
     */
    public T get(int index){
        if (index <= a.length && index >= 0){
            return a[index];
        }
        return null;
    }

    /*
     * Return the first index of element in the list. If element
     * is null or not found in the list, return -1. If isSorted is
     * true, uses the ordering of the list to increase the efficiency
     * of the search.
     */
    public int indexOf(T element){

        if (element!= null){

            for(int y = 0; y <= a.length; y++){
                if(a[y] == null) {
                    return -1;
                }
                else if (a[y].compareTo(element) == 0){
                   return y;
                }

                }
            }


        return -1;
    }
    //return -1;



    /*
     * Return true if the list is empty and false otherwise.
     */
    public boolean isEmpty(){
        if (len == 0){
            return true;
        }
        return false;
    }

    /*
     * Same as indexOf(), except it will return the last index
     * of element. If isSorted is true, uses the ordering
     * of the list to increase the efficiency of the search.
     */
    public int lastIndexOf(T element){
        int c= -1;
        if (element != null){

            for (int x = 0; x < a.length; x++){
                if(a[x] == null){
                    return c;
                }
                if (a[x].equals(element)){
                    c = x;

                    }

                }
            return c;
            }

        return c;
    }

    /*
     * Replace the element at index with element and return the
     * element that was previously at index. If index is
     * out-of-bounds or element is null, do nothing with element
     * and return null.
     */
    public T set(int index, T element) {
        if (index < a.length && index >= 0 && element != null) {
            for (int x= 0; x < a.length; x++){
                T temp = (T) a[index];
                if (x == index){
                    a[x] = element;
                    return temp;
                }
            }
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
    public void sort(boolean order){
        if (order == true){
            for (int x = 0; x < a.length -1;x++){
                for(int y = 0; y < a.length -x-1; y++){
                    if ( a[y].compareTo(a[y+1]) > 0){
                        T temp =(T) a[y];
                        a[y] = a[y+1];
                        a[y+1] = temp;
                    }
                }
            }
            isSorted = true;
        }
        else{
            for (int x = 0; x < a.length -1;x++){
                for(int y = 0; y < a.length -x-1; y++){
                    if ( a[y].compareTo(a[y+1]) < 0){
                        T temp =(T) a[y];
                        a[y] = a[y+1];
                        a[y+1] = temp;
                    }
                }
            }
        }
    }

    /*
     * Remove the first instance of element from the list. This
     * method should also shifts any subsequent elements to the
     * left (subtracts one from their indices). If successful,
     * return true. If element is not found in the list, return
     * false.
     */
    public boolean remove(T element){
        for (int x = 0; x < a.length; x++){
            if (a[x] == null){
                return false;
            }

            else if(a[x].equals(element)){
                for (int y = x; y < a.length-1;y++){
                    a[y] =a[y+1];
                }
                a[a.length-1] = null;
                return true;
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
        if (index >= 0 && index < len) {
            for (int x = 0; x < a.length; x++) {
                if (x == index) {
                    T temp = (T) a[x];
                    for (int y = x; y < a.length - 1; y++) {
                        a[y] = a[y + 1];
                    }
                    a[a.length - 1] = null;
                    return temp;
                }
            }
        }
        return null;
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
    public String toString(){
        String st = "";
        for(int x =0; x < a.length; x++){
            st += a[x] + " ";
        }
        return st;
    }


    public static void main(String[] args){
        ArrayList arr = new ArrayList();

        //System.out.println(arr.isEmpty());
        //System.out.println(arr);
        //System.out.println(arr.len);
        arr.add("cat");
        arr.add("dog");
        arr.add("snake");
        //System.out.println(arr.indexOf("horse"));
        //arr.remove(1);
        //arr.get(1);

        System.out.println(arr.contains("fish"));
        //arr.get(0);
        //arr.set(1, "horse");
        //.get(1);
        //arr.set(2, "tiger");
        // arr.get(2);

       // System.out.println(arr.len);
        //arr.contains("lizard");


        //System.out.println(arr.add(0,"fish"));
        //System.out.println(arr.add(3,"l"));


        System.out.println(arr);

    }
    //HONORS METHODS:
    //if you are an honors student please uncomment these methods

    /*
    returns a new List object containting the k smallest elements in the List.
    If k is less than 1 then null should be returned. If k is greater than or equal
    to the size of the list then the entire list should be returned.
     */
    //List<T> getKSmallest(int k);

    /*
    returns a new List object containting the k largest elements in the List.
    If k is less than 1 then null should be returned. If k is greater than or equal
    to the size of the list then the entire list should be returned.
     */
    //List<T> getKLargest(int k);
    // End of interface definition.

}