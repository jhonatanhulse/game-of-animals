package jhullse.gameofanimals.util.mutable;

public class BinaryTreeNavigatorImpl implements BinaryTreeNavigator {

    private BinaryTreeNode root;

    private BinaryTreeNode current;

    public BinaryTreeNavigatorImpl() {
        this(null);
    }

    public BinaryTreeNavigatorImpl(BinaryTreeNode root) {
        setRoot(root);
    }

    @Override
    public void setRoot(BinaryTreeNode root) {
        this.root = root;
        rewind();
    }

    @Override
    public BinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public BinaryTreeNode getCurrent() {
        return current;
    }

    @Override
    public BinaryTreeNode next(boolean isLeftChild) {
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
