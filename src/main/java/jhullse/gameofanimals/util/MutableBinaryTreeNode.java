package jhullse.gameofanimals.util;

public interface MutableBinaryTreeNode {

    void setParent(MutableBinaryTreeNode parent);

    MutableBinaryTreeNode getParent();

    boolean isRoot();

    void remove(MutableBinaryTreeNode child);

    void removeFromParent();

    boolean allowsChildren();

    void setLeftChild(MutableBinaryTreeNode leftChild);

    MutableBinaryTreeNode getLeftChild();

    void setRightChild(MutableBinaryTreeNode rightChild);

    MutableBinaryTreeNode getRightChild();

    boolean isLeaf();

    void setObject(Object object);

    Object getObject();
}
