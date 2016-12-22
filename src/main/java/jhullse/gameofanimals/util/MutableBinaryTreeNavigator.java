package jhullse.gameofanimals.util;

public interface MutableBinaryTreeNavigator {

    void setRoot(MutableBinaryTreeNode root);

    MutableBinaryTreeNode getRoot();

    MutableBinaryTreeNode next(boolean isLeftChild);

    void rewind();
}
