package 二叉树;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Describe 108. 将有序数组转换为二叉搜索树
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return bulidBST(nums, 0, nums.length-1);

    }
    //构建平衡树
    public TreeNode bulidBST(int[] nums, int start, int end) {
        if (start > end) return null;
        //中间节点
        int mid = start + (end - start >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bulidBST(nums,start,mid-1);
        root.right = bulidBST(nums,mid+1,end);
        return root;
    }
}
