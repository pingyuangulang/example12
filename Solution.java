/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 吉彬
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public static void main(String[] args){
        
    }
    /*
    问题：
    输入两棵二叉树A，B，判断B是不是A的子结构。
    （ps：我们约定空树不是任意一个树的子结构）
    */
    
    /*
    解决思路：
    首先在树A中找到和树B根节点值相同的节点R；
    然后判断树A中以R为根节点的子树是否包含了和树B一样的结构。
    */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1!=null && root2!=null){
            if(root1.val==root2.val)
                result = tree1InstanceOfTree2(root1,root2);
            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right,root2);
        }
        return result;
    }
    //判断node1是否包含node2的树型结构（对应节点值相同）
    private boolean tree1InstanceOfTree2(TreeNode node1,TreeNode node2){
        if(node2==null)
            return true;
        if(node1==null)
            return false;
        if(node1.val!=node2.val)
            return false;
        return tree1InstanceOfTree2(node1.left,node2.left) && tree1InstanceOfTree2(node1.right,node2.right);
    }
}
