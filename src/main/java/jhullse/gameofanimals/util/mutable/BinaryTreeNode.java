package jhullse.gameofanimals.util.mutable;

public interface BinaryTreeNode {

    void setParent(BinaryTreeNode parent);

    BinaryTreeNode getParent();

    boolean isRoot();

    void remove(BinaryTreeNode child);

    void removeFromParent();

    boolean allowsChildren();

    void setLeftChild(BinaryTreeNode leftChild);

    BinaryTreeNode getLeftChild();

    void setRightChild(BinaryTreeNode rightChild);

    BinaryTreeNode getRightChild();

    boolean isLeaf();

    void setObject(Object object);

    Object getObject();
}
