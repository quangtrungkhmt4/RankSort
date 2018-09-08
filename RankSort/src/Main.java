import java.util.ArrayList;

public class Main {

    public static boolean checkRun = true;

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<>();   // mảng số ban đầu
        ArrayList<Integer> rank = new ArrayList<>();    // mảng vị trí
        array.add(2); array.add(3); array.add(-1); array.add(0); array.add(2); array.add(3); array.add(-1);
        array.add(5); array.add(8); array.add(2); array.add(4); array.add(-10); array.add(15); array.add(-2);
        array.add(2); array.add(3); array.add(-1); array.add(0); array.add(2); array.add(3); array.add(-1);
        array.add(5); array.add(8); array.add(2); array.add(4); array.add(-10); array.add(15); array.add(-2);// thêm phần tử vào mảng

        System.out.println("Array " + array.toString());
        System.out.println();

        // tách mảng thành 2 phần
        ArrayList<Integer> arrayZone1 = new ArrayList<>();
        ArrayList<Integer> arrayZone2 = new ArrayList<>();

        for (int i=0; i<=array.size()/2; i++){
            arrayZone1.add(array.get(i));
        }

        for (int i=(array.size()/2)+1; i<array.size(); i++){
            arrayZone2.add(array.get(i));
        }

        System.out.println("Array_Zone1 " + arrayZone1.toString());
        System.out.println("Array_Zone2 " + arrayZone2.toString());

        // chia 2 mảng Zone vào 2 luồng

        Thread thread_one = new MyThread("Thread_one",arrayZone1,array);
        Thread thread_two = new MyThread("Thread_two",arrayZone2,array);

        thread_one.start();
        thread_two.start();

         // luồng kiểm tra trạng thái của 2 luồng xử lý

        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (checkRun){
                    if (((MyThread) thread_one).isRunning() == false && ((MyThread) thread_two).isRunning() == false){
                        System.out.println("Rank Zone one: " + ((MyThread) thread_one).getRank().toString());
                        System.out.println("Rank Zone one: " + ((MyThread) thread_two).getRank().toString());
                        rank.addAll(((MyThread) thread_one).getRank());
                        rank.addAll(((MyThread) thread_two).getRank());
                        Sort sort = new Sort(rank,array);
                        sort.rankSort();
                        checkRun = false;

                    }
                }
            }
        });
        mainThread.start();


    }



}
