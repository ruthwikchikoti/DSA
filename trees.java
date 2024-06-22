import java.util.*;
public class trees {
    
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left =null;
            this.right = null; 
        }

    }

    static class BinaryTree{
        static int idx = -1;
        public TreeNode buildtree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildtree(nodes);
            newNode.right = buildtree(nodes);
            return newNode;

        }
    }

    public static void printpreorder(TreeNode root){
        if(root == null){
            return ;

        }
        System.out.print(root.data+ "   ");
        printpreorder(root.left);
        printpreorder(root.right);
         
    }

    public static void printInorder(TreeNode root){
        if(root == null){
            return ;

        }
        printInorder(root.left);
        System.out.print(root.data+ "   ");
        printInorder(root.right);
         
    }
    public static void printpostorder(TreeNode root){
        if(root == null){
            return;
        }
        printpostorder(root.left);
        printpostorder(root.right);
        System.out.print(root.data+ "   ");
    }
    public static void main(String[] args) {
        int nodes [] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        TreeNode rooot = tree.buildtree(nodes);
        System.out.println(rooot.data);
        printpreorder(rooot);
        System.out.println();
        printInorder(rooot);
        System.out.println();
        printpostorder(rooot);
    }
}
