

/**
 * Created by Niocle on 2017/8/23.
 */
 
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class IsBalancedTree {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        boolean res = IsBalanced_Solution(root);
        System.out.println(res);
    }

    private static boolean  isBalance = true;
    public static boolean IsBalanced_Solution(TreeNode root) {
        DeepOfTree(root);
        return isBalance;
    }

    public static int DeepOfTree(TreeNode root){
        if(root == null)
            return 0;
        int left = DeepOfTree(root.left);
        int right = DeepOfTree(root.right);
        if(Math.abs(left - right) > 1){
            isBalance = false;
        }
        return right > left? right+1: left+1;
    }
}
