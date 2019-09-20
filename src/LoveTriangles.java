// First realization of problem (with cycle)
public class LoveTriangles {
    static int getLoveTrianglesCount(Integer [] array){
        int count=0;
        for (int i=0;i<array.length;i++){
            if (array[i]>-1){
                int nextLover=i; //initilize nextLover
                int countLovers=1;
                do{                 //counting of Lovers in chain and set couned "-1" to prevent double dount in triangle
                    int temp=nextLover;
                    nextLover=array[nextLover];
                    array[temp]=-1;
                    countLovers++;
                }while(array[nextLover]!=i);
                array[nextLover]=-1; //setting of last Lover in chain to "-1"
                if (countLovers>2)
                    count++;
            }
        }
        return count;
    }

    //Second realization of problem(with recursion)

    //recursed method
    static int nextLover(Integer[] array, int firstLover, int nextLover) {

        int x = array[nextLover]; //save next-next lover
        array[nextLover] = -1;    // set next-Lover -1 to prevent double count

        //step into( to next-next lover
        if (x != firstLover) {
            if (x>-1)
                return nextLover(array, firstLover, x)+1;
            else
                return 2;
        }
        return 1;
    }

    //main function of second method  for use method with recursion
    static int getLoveTrianglesCountwithRecurse(Integer[] array) {
        int count=0;
        for (int i = 0; i < array.length; i++) {
            //System.out.println("i: " + i);
            if (array[i] > -1) {
                if (nextLover(array, i, array[i])>1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {


    //input your array here
    Integer array[]={9, 4, 3 , 6, 5, 1, 2 , 0,10, 7 , 8};
    System.out.println("Count of triangles: "+ getLoveTrianglesCount(array));
    Integer array1[]={9, 4, 3 , 6, 5, 1, 2 , 0,10, 7 , 8};
    System.out.println("Count of triangles by recurse: "+ getLoveTrianglesCountwithRecurse(array1));

    }
}
