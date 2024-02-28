public class SelfOrganizingList {

    private  int[] list;

    private int[] count;

    private int size;

    public SelfOrganizingList(int listsize){
        list  = new int[listsize];

        count = new int[listsize];

        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }

    public void insert(int val){
        if(isFull()){
            System.out.println("is full ):");
            return;
        }

        list[size] = val;

        count[size] = 0;

        size++;
    }

    public void remove(int idx){
        idx--;
        if(idx < 0 || idx > size){
            System.out.println("Invalid position");
            return;
        }

        for( int i = idx; i < size; i++){
            list[i] = list[i + 1];
            count[i] = count[i + 1];
        }

        size--;
    }

    public boolean search(int x){
        boolean searchResult = false;

        int pos = 0;

        for (int i = 0; i < size; i++){
            if(list[i] == x){
                searchResult = true;
                pos = i;
                break;
            }
        }

        if(searchResult){
            //increment count
            count[pos]++;

            //store count
            int c = count[pos];

            //adjusting the arrays
            for(int i = 0; i< pos; i++){

                if(count[pos] > count[i]){

                    for(int j = pos; j > i; j--){
                        list[j] = list[j -1];
                        count[j] = count[j -1];
                    }

                    list[i] =x;
                    count[i] = c;
                    break;
                }
            }
        }
        return searchResult;
    }

    public void printList(){
        System.out.print("\nList = ");
        for(int i=0; i < size; i++){
            System.out.print(list[i] + " ");
        }
        System.out.print("\nCount = ");
        for(int i=0; i < size; i++){
            System.out.print(count[i] + " ");
        }
    }
}
