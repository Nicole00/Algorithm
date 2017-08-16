package Test;


/**
 * Created by wangchangyuan on 2017/8/15.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class IsSubTree {
    public static  void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeNode res = Mirror(root);
        System.out.println(res.val);
        System.out.println(res.left.val);
        System.out.println(res.right.val);
        System.out.println(res.left.left.val);
        System.out.println(res.right.left.val);
        System.out.println(res.right.right.val);

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static boolean isSubtree(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null && B != null) return false;
        if(A.val == B.val)
            return isSubtree(A.left, B.left) && isSubtree(A.right, B.right);
        else
            return false;
    }

    public static TreeNode Mirror(TreeNode root) {
        if(root == null)
            return null;
        while(root != null){
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            Mirror(root.left);
            Mirror(root.right);
            return root;
        }
        return root;
    }


}
