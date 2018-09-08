import java.util.ArrayList;

public class MyThread extends Thread{

    private ArrayList<Integer> array;
    private ArrayList<Integer> array_full;
    private ArrayList<Integer> rank;
    private boolean isRunning;

    public MyThread(String name,ArrayList<Integer> array, ArrayList<Integer> array_full ) {
        super(name);
        this.array = array;
        this.array_full = array_full;
        isRunning = true;
        rank = new ArrayList<>();
    }

    @Override
    public void run() {
        super.run();

        System.out.println("Start " + this.getName());

        for (int i=0; i<array.size(); i++){
            int countNumLess = 0;
            for (int j=0; j<array_full.size(); j++){
                if (array_full.get(j) < array.get(i)){
                    countNumLess++;
                }
            }
            rank.add(countNumLess);
        }
        System.out.println("Finish " + this.getName());

        isRunning = false;

    }

    public ArrayList<Integer> getRank() {
        return rank;
    }


    public boolean isRunning() {
        return isRunning;
    }
}
