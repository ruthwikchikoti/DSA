import java.util.LinkedList;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;

    }
}

public class Trees {

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        postorder(root.left);
        postorder(root.right);

    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        System.out.println(root.data + " ");
        preorder(root.right);

    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + " ");

    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    public static int verify_2treenodes_are_same(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return 1;
        }
        if (root1 == null || root2 == null) {
            return 0;
        }
        if (root1.data != root2.data) {
            return 0;
        }
        int isLeftSame = verify_2treenodes_are_same(root1.left, root2.left);
        int isRightSame = verify_2treenodes_are_same(root1.right, root2.right);
        if (isLeftSame == 1 && isRightSame == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int mirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return 1;
        }
        if (root1 == null || root2 == null) {
            return 0;
        }
        if (root1.data != root2.data) {
            return 0;
        }
        int isLeftSame = mirror(root1.left, root2.right);
        int isRightSame = mirror(root1.right, root2.left);
        if (isLeftSame == 1 && isRightSame == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    // given a binary tree retuen the invert of the tree
    public static TreeNode invert(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode left = invert(A.left);
        TreeNode right = invert(A.right);
        A.left = right;
        A.right = left;
        return A;
    }

    // given a binary tree return level order traversal of the tree
    public static ArrayList<ArrayList<Integer>> levelorder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                level.add(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    // given a binary tree return left view of the tree
    public static ArrayList<Integer> leftview(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (i == 0) {
                    ans.add(temp.data);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }

            }
        }
        return ans;
    }

    // given a binary tree return right view of the tree
    public static ArrayList<Integer> rightview(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (i == size - 1) {
                    ans.add(temp.data);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return ans;
    }

    // given a binary tree return vertical order traversal of the tree
    public static ArrayList<ArrayList<Integer>> verticalorder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                level.add(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    // given a binary tree return top view of the tree
    public static ArrayList<Integer> topview(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (i == 0) {
                    ans.add(temp.data);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }

            }
        }
        return ans;
    }

    // given a binary tree return bottom view of the tree
    public static ArrayList<Integer> bottomview(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (i == size - 1) {
                    ans.add(temp.data);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return ans;
    }

    // given a binary search tree insert a val in the tree
    public static int search(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.data == val) {
            return 1;
        }
        if (root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }
    // given a binary search tree delete a val in the tree

    public static TreeNode delete(TreeNode A, int B) {
        if (A == null)
            return null;
        if (A.data < B) {
            A.right = delete(A.right, B);
        } else if (A.data > B) {
            A.left = delete(A.left, B);
        } else {
            if (A.left == null && A.right == null) {
                return null;
            } else if (A.left == null) {
                return A.right;
            } else if (A.right == null) {
                return A.left;
            } else {
                TreeNode max = getmax(A.left);
                A.data = max.data;
                A.left = delete(A.left, A.data);
            }
        }
        return A;
    }

    public static TreeNode getmax(TreeNode A) {
        if (A == null)
            return null;

        while (A.right != null) {
            A = A.right;
        }
        return A;
    }


    // given a binary tree verify if it is a hieight balanced tree
    public static int isBalanced(TreeNode A) {
        if (A == null) {
            return 1;
        }
        int leftheight = height(A.left);
        int rightheight = height(A.right);
        if (Math.abs(leftheight - rightheight) <= 1 && isBalanced(A.left    ) == 1 && isBalanced(A.right) == 1) {
            return 1;
        } else {
            return 0;
        }
    }
    
    
    // valid binary search tree
    public static int isValidBST(TreeNode A) {
        if (A == null) {
            return 1;
        }
        if (A.left != null && A.left.data >= A.data) {
            return 0;
        }
        if (A.right != null && A.right.data <= A.data) {
            return 0;
        }
        int left = isValidBST(A.left);
        int right = isValidBST(A.right);
        if (left == 1 && right == 1) {
            return 1;
        } else {
            return 0;
        }
    }


    // given a BT return the diameter of the tree
    public static int diameter(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int left = height(A.left);
        int right = height(A.right);
        int leftdiameter = diameter(A.left);
        int rightdiameter = diameter(A.right);
        return Math.max(left + right + 1, Math.max(leftdiameter, rightdiameter));
    }

    //given a binary tree return the lowest common ancestor of the two nodes
   
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(25);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(8);
        // root.right.left = new TreeNode(1);
            System.out.println(delete(root, 0));
    }
}
