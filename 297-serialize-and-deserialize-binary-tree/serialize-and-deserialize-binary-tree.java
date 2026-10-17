public class Codec {
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    public TreeNode deserialize(String data){
        String[] arr = data.split(",");
        int[] index = {0};
        return buildTree(arr, index);
    }
    private TreeNode buildTree(String[] arr, int[] index){
        String value = arr[index[0]++];

        if(value.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = buildTree(arr, index);
        root.right = buildTree(arr, index);

        return root;
    }
}
