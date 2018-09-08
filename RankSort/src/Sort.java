import java.util.ArrayList;

public class Sort {
    private ArrayList<Integer> rank;
    private ArrayList<Integer> array;
    private ArrayList<Integer> array_sorted;

    public Sort(ArrayList<Integer> rank, ArrayList<Integer> array) {
        this.rank = rank;
        this.array = array;
        array_sorted = new ArrayList<>();
        array_sorted.addAll(array);
    }

    public void rankSort(){
        // mảng Rank nếu có các vị trí trùng nhau
        // lọc các vị trí trùng
        for (int i=0; i<rank.size(); i++){
            for (int j=0; j<i; j++){
                if (rank.get(i) == rank.get(j)){
                    rank.set(i,rank.get(j)+1);
                }
            }
        }
        System.out.println();
        System.out.println("New Rank " + rank.toString());


        // sắp xếp lại dãy theo thứ tự của mảng Rank sau khi lọc trùng
        System.out.println("");
        for (int i=0; i<rank.size(); i++){
            //System.out.println(array.indexOf(array.get(i)));
            array_sorted.set(rank.get(i),array.get(i));
        }
        System.out.println("Sorted "+array_sorted.toString());
    }
}
