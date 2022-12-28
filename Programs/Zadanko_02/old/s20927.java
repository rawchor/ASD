package Zadania.Zadanko_02.old;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class s20927{
    public static void main(String[] args) throws IOException{
        String inputline;

        Tree tree = new Tree();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String string;

        while((string = bufferedReader.readLine()) != null){
            inputline = string;
            String[] array = inputline.split(" ");
            if(inputline.length() > 0){
                if(array.length == 1){
                    tree.addNode(array[0].charAt(0), null);
                }else if (array.length == 2){
                    tree.addNode(array[0].charAt(0), array[1]);
                }
            }
        }
        System.out.print(tree.getLongestWord());
    }
}

class Node{
    public Node left;
    public Node right;
    public char value;

    public Node(Node left, Node right, char value){
        this.left = left;
        this.right = right;
        this.value = value;
    }
}

class Tree{
    public String longestWord = "";
    public Node Root;

    public Tree(){
        Root = new Node(null, null, ' ');
    }

    public void addNode(char value, String path){
        if(path == null){
            Root.value = value;
            return;
        }

        int index;
        int pathLength = path.length();

        Node cNode = Root;

        index = 0;
        while(index < pathLength){
            char key = path.charAt(index);
            boolean isLeft = key == 'L';
            boolean isRight = key == 'R';

            if(isLeft ? (cNode.left == null) : (cNode.right == null)){
                Node node = new Node(null, null, ' ');
                if(isLeft){
                    cNode.left = node;
                }else if(isRight){
                    cNode.right = node;
                }
            }

            if(isLeft){
                cNode = cNode.left;
            }else if(isRight){
                cNode = cNode.right;
            }

            if(index == (pathLength - 1)){
                cNode.value = value;
            }
            index++;
        }
}

    public void findLongestWord(Node node, String word){
        if(node.left != null){
            String tmpWord = "";
            if(node.left.value != ' '){
                tmpWord = "" + node.left.value;
            }
            tmpWord += word;
            findLongestWord(node.left, tmpWord);
        }

        if(node.right != null){
            String newWord = "";
            if(node.right.value != ' '){
                newWord = "" + node.right.value;
            }
            newWord += word;
            findLongestWord(node.right, newWord);
        }

        if(node.left == null && node.right == null){
            if(word.compareTo(longestWord) > 0){
                longestWord = word;
            }
        }
    }

    public String getLongestWord(){
        findLongestWord(Root, ("" + Root.value));
        return longestWord;
    }
}