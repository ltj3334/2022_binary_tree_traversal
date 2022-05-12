import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Tree {
    Node root;

    public Tree(char d, char l, char r) {
        root = new Node(d);
        if(d != '.')
            root = new Node(d);
        if(l != '.')
            root.left = new Node(l);
        if(r != '.')
            root.right = new Node(r);
    }

    public static void preorder(Node root) {
        System.out.print(root.data + " ");
        /*
        코드 작성
        */
    }
    public static void postorder(Node root) {
        /*
        코드 작성
        */
        System.out.print(root.data + " ");
    }
    public static void inorder(Node root) {
        /* 코드 작성 */
        System.out.print(root.data + " ");
        /* 코드 작성 */
    }
	public void insert(char d, char l, char r) {
        search(root.left, d, l, r);
        search(root.right, d, l, r);
    }
	public void search(Node node, char d, char l, char r) {
        if(node == null) {
            return ;
        } 
        if (node.data == d) {
            if (l!= '.')
                node.left = new Node(l); 
            if (r!= '.')
                node.right= new Node(r); 
        } else {
            search(node.left, d, l, r);
            search(node.right, d, l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        char[] data = in.readLine().replaceAll(" ", "").toCharArray();

        // root node
        Tree tree = new Tree(data[0], data[1], data[2]);

        // remaining nodes
        for(int i = 1; i < n; i++) {
            data = in.readLine().replaceAll(" ", "").toCharArray();
            tree.insert(data[0], data[1], data[2]);
        }
        
        postorder(tree.root);
        System.out.println();
        inorder(tree.root);
        System.out.println();
        preorder(tree.root);
    }

}

class Node {
    char data;
    Node left;
    Node right;
    
    Node(char data) {
        this.data = data;
    }
}
