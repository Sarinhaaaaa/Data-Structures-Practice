
import java.util.*;
public class AdjacencyList {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addNode('D');
        graph.addNode('E');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,0);
        graph.addEdge(4,2);

        graph.removeNode('A');

        graph.removeEdge(1,2);
        
        graph.print();
    }

    public static class Graph{
        ArrayList<LinkedList<Character>> alist;
        
        Graph(){
            alist = new ArrayList<>();
        }

        public void addNode(char node){
            LinkedList<Character> currentList = new LinkedList<>();
            currentList.add(node);
            alist.add(currentList);

        }

        public void removeNode(char targetNode){
        int targetIndex = -1;
        
        for(int i = 0; i < alist.size(); i++){
            if(alist.get(i).get(0) == targetNode){
                targetIndex = i;
                break;
            }
        }

        if (targetIndex != -1){
            for(LinkedList<Character> currentList : alist){
                for(int i = 0; i < currentList.size(); i++){
                    if(currentList.get(i) == targetNode){
                        currentList.remove(i);
                        i--;
                    }
                }
            }
            alist.remove(targetIndex);
        }
            
            
    }
        

        public void addEdge(int src, int dst){
            LinkedList<Character> currentList = alist.get(src);
            Character dstNode = alist.get(dst).get(0);
            currentList.add(dstNode);

        }

        public void removeEdge(int src, int dst){
            Character srcNode = alist.get(dst).get(0);
            Character dstNode = alist.get(dst).get(0);
        if(srcNode >= 0 && src < alist.size() && dst >= 0 && dst < alist.size()){
            alist.get(src).remove(dstNode);
        }
    }

        public boolean checkEdge(int src, int dst){
            LinkedList<Character> currentList = alist.get(src);
            Character dstNode = alist.get(dst).get(0);

            for(char node : currentList){
                if(node == dstNode){
                    return true;
                }

            }return false;

        }


        public void print(){
            for(LinkedList<Character> currentList : alist){
                Character startNode = currentList.get(0);
                System.out.print(startNode + ": ");
                for(int i = 1; i < currentList.size(); i++){
                    System.out.print(currentList.get(i));
                    if(i < currentList.size() - 1) System.out.print(" -> ");

                }
                System.out.println();

            }

        }

    }   

}
