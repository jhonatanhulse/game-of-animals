package jhullse.gameofanimals.util;

import java.beans.Transient;

public interface MutableBinaryTreeNode {

    @Transient
    void setParent(MutableBinaryTreeNode parent);

    @Transient
    MutableBinaryTreeNode getParent();

    boolean isRoot();

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
