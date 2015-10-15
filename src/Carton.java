import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Fincken on 13.10.2015.
 */
public class Carton {
    ArrayList<ArrayList<cartonNode>> carton;
    ArrayList<Character> init;


    public Carton(int m, int n){
        genStart(m,n);
        createCarton(m,n);
    }

    public void genStart(int m, int n){
        int length = m*n;
        ArrayList<Character> board = new ArrayList<Character>();
        final int[] ints = new Random().ints(1, 25).distinct().limit(10).toArray();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i : ints){
            numbers.add(i);
        }
        for (int i = 0; i < length; i++) {
            if(numbers.contains(i))
                board.add('0');
            else
                board.add('.');
        }
        this.init = board;
    }

    public void createCarton(int m, int n){
        this.carton = new ArrayList<ArrayList<cartonNode>>();
        for (int i = 0; i < m; i++) {
            carton.add(i,new ArrayList<cartonNode>());
            for (int j = 0; j < n; j++) {
                carton.get(i).add(new cartonNode(init.get(i*n+j), j,i));
            }
        }
    }

    public String toString(){
        String board = "";
        for (int i = 0; i < this.carton.size(); i++) {
            for (int j = 0; j < this.carton.size(); j++) {
                board += carton.get(i).get(j).toString()+" ";
            }
            board += "\n";
        }
        return board;
    }

    public ArrayList<ArrayList<cartonNode>> getCarton(){
        return this.carton;
    }

    public static void main(String[] args){
        Carton c = new Carton(5,5);
        System.out.println(c.toString());
        Evaluation ev = new Evaluation(2);
        ev.legalCheck(c.getCarton());
        System.out.println(c.toString());
    }



}


