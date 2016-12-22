package jhullse.gameofanimals.util;

public class MutableBinaryTreeNavigatorImpl implements MutableBinaryTreeNavigator {

    private MutableBinaryTreeNode root;

    private MutableBinaryTreeNode current;

    public MutableBinaryTreeNavigatorImpl() {
        this(null);
    }

    public MutableBinaryTreeNavigatorImpl(MutableBinaryTreeNode root) {
        setRoot(root);
    }

    @Override
    public void setRoot(MutableBinaryTreeNode root) {
        this.root = root;
        rewind();
    }

    @Override
    public MutableBinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public MutableBinaryTreeNode next(boolean isLeftChild) {
        if (current != null) {
            if (isLeftChild) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return current;
    }

    @Override
    public void rewind() {
        current = root;
    }
}
