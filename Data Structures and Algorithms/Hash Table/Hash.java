public class Hash<T> {

    NGen<T>[] arr;
    public Hash(){

        arr =  new NGen[100];
    }


    // Created differnt methods for each hash method used
    // #1 Hash method

    public int hash1(T key){
        String a = (String) key;
        //int x = a.toLowerCase();
        int temp = 0;
        for (int x = 0; x < a.length(); x ++){
            if (x == 0){
                temp +=  a.charAt(x) / 2;
            }
            else{
                temp +=  a.charAt(x);
            }
        }
        return temp % arr.length;
    }
    public int hash11(T key){
        String a = (String) key;
        //int x = a.toLowerCase();
        int temp = 0;
        if (a.length() > 6){

            temp = a.charAt(0)+10;
        }
        else {
            for (int x = 0; x < a.length(); x++) {
                if (x == 0) {
                    temp += a.charAt(x) / 2;
                } else {
                    temp += a.charAt(x);
                }
            }
        }
        return temp % arr.length;
    }
    // #2 Hash method
    public int hash2(T key){
        String a = (String) key;
        //int x = a.toLowerCase();
        int temp = 0;

        temp +=  a.charAt(0)-97 + a.charAt(1)+96;
        return temp % arr.length;
    }

    // #3 Hash method
    public int hash33(T key){
        String a = (String) key;
        //int x = a.toLowerCase();
        int temp = 0;

        for (int x = 0; x < a.length(); x ++){
            temp = 31*+ a.charAt(x);
        }
        return temp % arr.length;
    }

    public int hash3(T key){
        String a = (String) key;
        //int x = a.toLowerCase();
        int temp = 0;
        if (a.length() < 4){
            temp = a.charAt(0)-97 + a.charAt(1)-97;
        }
        else {
            for (int x = 0; x < a.length(); x++) {
                if (x==0) {
                    temp += a.charAt(x)*5;
                } else if (x == 1) {
                    temp += a.charAt(x) *5;
                } else if (x == 2) {
                    temp += a.charAt(x) * 5;
                } else {
                    temp += a.charAt(x);
                }
            }
        }
        return temp % arr.length;
    }

    // #24Hash method

    public int hash4(T key){
        String a = (String) key;
        //int x = a.toLowerCase();
        int temp = 0;
        for (int x = 0; x < a.length(); x ++){
            if (x == 0){
                temp +=  a.charAt(x)*2;
            }
            else if (x== 1){
                temp +=  a.charAt(x)/2 ;
            }
            else if (x== 2){
                temp +=  a.charAt(x)*2;
            }
            else{
                temp +=  a.charAt(x);
            }
        }
        return temp % arr.length;
    }

    public void add(T item) {
        if (item.equals(",")) {

        }
        int index = hash1(item);
        if(arr[index] == null){
            arr[index] = new NGen(item, null);
        }
        else{
          NGen current = arr[index];

           while(current.getNext() != null){
               if (!current.getData().equals(item)){
                   current = current.getNext();
               }
               else{
                   return;
               }

           }
            if (current.getData().equals(item)){
                return;
            }

           NGen a = new NGen(item, null);
           current.setNext(a);


        }


    }



    public void add1(T item) {
        if (item.equals(",")) {

        }
        int index = hash1(item);
        if(arr[index] == null){
            arr[index] = new NGen(item, null);
        }
        else{
            NGen current = arr[index];

            while(current.getNext() != null){
                if (!current.getData().equals(item)){
                    current = current.getNext();
                }
                else{
                    return;
                }

            }
            if (current.getData().equals(item)){
                return;
            }

            NGen a = new NGen(item, null);
            current.setNext(a);


        }

    }

    public void display(){
        int  m= 0;
        int l = 0;

        for(int x = 0; x < arr.length; x++){
            int temp = 0;
            String s = "";
            if (arr[x] != null){
                NGen current = arr[x];
                int count =0;
                while(current != null){
                    s += current.getData() + ", ";
                    current = current.getNext();
                    count++;
                }
                temp = count;



                }

            System.out.println(x + ": " + temp+ " Tokens: "+ s);
        }
    }
    public void max(){
        int temp2= 0;
        int temp =0;
        for(int x= 0; x < arr.length; x++){
            NGen current = arr[x];
            int count =0;
            while(current != null){
                current = current.getNext();
                count++;
            }

            if ( count > temp){
                temp2 = x;
                temp = count;
            }

        }
        System.out.println("At index: "+ temp2 + " with "+ temp+ " elements");
    }
    public static void main(String[] args){
        //System.out.println(mystery());
        //Hash obj = new Hash();
        //obj.add("cat");
        //obj.add("cat");
        //obj.display();

    }


}
