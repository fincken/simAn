import java.util.ArrayList;

/**
 * Created by Fincken on 14.10.2015.
 */
public class Evaluation {
    private int k;

    public Evaluation(int k){
        this.k = k;
    }

    public void legalCheck(ArrayList<ArrayList<cartonNode>> board){

        // Horizontal check
        for (ArrayList<cartonNode> list: board) {
            int eggCount = 0;
            for(cartonNode node: list){
                if(node.isEgg())
                    eggCount += 1;
                if(eggCount > k && node.isEgg())
                    node.setBad(true);
            }
        }

        for (int i = 0; i < board.size(); i++) {
            int eggCount = 0;
            for (int j = 0; j < board.get(i).size(); j++) {
                if(board.get(j).get(i).isEgg())
                    eggCount += 1;
                if(eggCount>k  && board.get(j).get(i).isEgg())
                    board.get(j).get(i).setBad(true);
            }
        }

        for (int i = 0; i < board.get(0).size(); i++) {
            int eggCount = 0;
            int xCount = i;
            int yCount = board.size()-1;
            while(yCount>=i){
                if(board.get(yCount).get(xCount).isEgg())
                    eggCount += 1;
                if(eggCount>k  && board.get(yCount).get(xCount).isEgg())
                    board.get(yCount).get(xCount).setBad(true);
                xCount++;
                yCount--;
            }
        }

        for (int i = board.size()-2,j=0 ; i >=0 ; i--,j++) {
            int eggCount = 0;
            int xCount = i;
            int yCount = 0;
            while(yCount<board.size()-1-j) {
                if (board.get(yCount).get(xCount).isEgg())
                    eggCount += 1;
                if (eggCount > k  && board.get(yCount).get(xCount).isEgg())
                    board.get(yCount).get(xCount).setBad(true);
                xCount--;
                yCount++;
            }
        }
        for (int i = 0; i < board.size() ; i++) {
            int eggCount = 0;
            int xCount = i;
            int yCount = 0;
            while(yCount<board.size()-i){
                if(board.get(yCount).get(xCount).isEgg())
                    eggCount += 1;
                if(eggCount>k  && board.get(yCount).get(xCount).isEgg())
                    board.get(yCount).get(xCount).setBad(true);
                xCount++;
                yCount++;
            }
        }

        for (int i = board.size()-2,j=1; i >=0 ; i--,j++) {
            int eggCount = 0;
            int xCount = i;
            int yCount = board.size()-1;
            while(yCount>=j) {
                if (board.get(yCount).get(xCount).isEgg())
                    eggCount += 1;
                if (eggCount > k && board.get(yCount).get(xCount).isEgg())
                    board.get(yCount).get(xCount).setBad(true);
                xCount--;
                yCount--;
            }
        }

    }
}