public class BinaryTreeUtils<E extends Comparable<E>> {

    public Integer countNodesWithHeight(BinaryTree<E> tree, Integer h) {
        // Call the helper method to start counting from the root
        return countNodesWithHeightHelper(tree.getRoot(), h);
    }

    private Integer countNodesWithHeightHelper(BinaryTreeNode<E> node, Integer targetHeight) {
        if (node == null) {
            // If the node is null and targetHeight is -1, it's considered a match
            return targetHeight == -1 ? 1 : 0;
        }

        // Calculate the height of the left and right subtrees
        Integer leftSubtreeHeight = getHeight(node.getLeftChild());
        Integer rightSubtreeHeight = getHeight(node.getRightChild());

        // Determine the height of this node as 1 plus the max of left/right subtree
        // heights
        Integer nodeHeight = 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);

        // Check if the node's subtree height matches the target height
        int match = nodeHeight == targetHeight ? 1 : 0;

        // Recursively count matches in the left and right subtrees
        Integer leftMatches = countNodesWithHeightHelper(node.getLeftChild(), targetHeight);
        Integer rightMatches = countNodesWithHeightHelper(node.getRightChild(), targetHeight);

        // Sum the matches for this node and its subtrees
        return match + leftMatches + rightMatches;
    }

    private Integer getHeight(BinaryTreeNode<E> node) {
        if (node == null) {
            // Base case: if the node is null, its height is -1
            return -1;
        }
        // Recursive case: height is 1 plus the maximum of the heights of left/right
        // children
        return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
    }

    public static void main(String[] args) {
        // Creating a simple binary tree for demonstration
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

        // Adding root and some children
        tree.addRoot(10); // Root node
        tree.getRoot().addLeftChild(5); // Adds a left child to the root
        tree.getRoot().addRightChild(15); // Adds a right child to the root

        // Adding children to the left child of the root
        tree.getRoot().getLeftChild().addLeftChild(2);
        tree.getRoot().getLeftChild().addRightChild(7);

        // Using countNodesWithHeight to find nodes with height 1 in the tree
        BinaryTreeUtils<Integer> utils = new BinaryTreeUtils<>();
        int height = 1; // Example height to test for
        int count = utils.countNodesWithHeight(tree, height);
        System.out.println("Number of nodes with height " + height + ": " + count);
    }
}
