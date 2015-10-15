import java.util.ArrayList;

/**
 * Created by Fincken on 15.10.2015.
 */
public class SimAn {
    ArrayList<Carton> totalBoards = new ArrayList<Carton>();
    ArrayList<Carton> neighbours = new ArrayList<Carton>();
    private Carton currentCarton;

    public SimAn(int m,int n){
        currentCarton = new Carton(m, n);

    }
    public void createNeighborsForAll(){
        for (int i = 0; i < currentCarton.getyMax()-1; i++) {
            for (int j = 0; j < currentCarton.getxMax()-1; j++) {
                if(currentCarton.getNode(j,i).isBad()){
                    createNeighborBoards(currentCarton.getNode(j,i));
                }

            }

        }
    }

    public void createNeighborBoards(cartonNode Node){

        //Check Right
        if(Node.getX()!=currentCarton.getxMax()-1 && !currentCarton.getNode(Node.getX()+1, Node.getY()).isEgg()){
            Carton neighbour = currentCarton;
            int x = Node.getX();
            int y = Node.getY();
            cartonNode currentTemp = Node;
            cartonNode rightNode = neighbour.getNode(x+1,y);
            currentTemp.setX(x+1);
            currentTemp.setGood();
            rightNode.setX(x);
            rightNode.removeEgg();
            neighbour.getCarton().get(y).set(x + 1, currentTemp);
            neighbour.getCarton().get(y).set(x, rightNode);
            neighbours.add(neighbour);
        }
        //Check Left
        if(Node.getX()!=0 && !currentCarton.getNode(Node.getX()-1, Node.getY()).isEgg()){
            Carton neighbour = currentCarton;
            int x = Node.getX();
            int y = Node.getY();
            cartonNode currentTemp = Node;
            cartonNode rightNode = neighbour.getNode(x-1,y);
            currentTemp.setX(x-1);
            currentTemp.setGood();
            rightNode.setX(x);
            rightNode.removeEgg();
            neighbour.getCarton().get(y).set(x - 1, currentTemp);
            neighbour.getCarton().get(y).set(x, rightNode);
            neighbours.add(neighbour);
        }
        //Check Up
        if(Node.getY()!=0 && !currentCarton.getNode(Node.getX(), Node.getY()-1).isEgg()){
            Carton neighbour = currentCarton;
            int x = Node.getX();
            int y = Node.getY();
            cartonNode currentTemp = Node;
            cartonNode rightNode = neighbour.getNode(x,y-1);
            currentTemp.setY(y - 1);
            currentTemp.setGood();
            rightNode.setY(y);
            rightNode.removeEgg();
            neighbour.getCarton().get(y-1).set(x, currentTemp);
            neighbour.getCarton().get(y).set(x, rightNode);
            neighbours.add(neighbour);
        }
        //Check Down
        if(Node.getY()!=currentCarton.getyMax()-1 && !currentCarton.getNode(Node.getX(), Node.getY()+1).isEgg()){
            Carton neighbour = currentCarton;
            int x = Node.getX();
            int y = Node.getY();
            cartonNode currentTemp = Node;
            cartonNode rightNode = neighbour.getNode(x,y+1);
            currentTemp.setY(y + 1);
            currentTemp.setGood();
            rightNode.setY(y);
            rightNode.removeEgg();
            neighbour.getCarton().get(y+1).set(x, currentTemp);
            neighbour.getCarton().get(y).set(x, rightNode);
            neighbours.add(neighbour);
        }


    }
    public String toString(){
        return currentCarton.toString();
    }
    public Carton getCurrentCarton(){
        return this.currentCarton;
    }


    public static void main(String[] args){

        SimAn sim = new SimAn(5,5);
        System.out.println(sim.toString());
        Evaluation ev = new Evaluation(2);
        ev.legalCheck(sim.getCurrentCarton());
        System.out.println(sim.toString());
        sim.createNeighborsForAll();
        for (int i = 0; i < sim.neighbours.size() ; i++) {
            System.out.print("Neigbour: "+i+"\n"+sim.neighbours.get(i).toString());
        }


    }
}
