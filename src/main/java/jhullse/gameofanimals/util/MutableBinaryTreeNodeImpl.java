package jhullse.gameofanimals.util;

public class MutableBinaryTreeNodeImpl implements MutableBinaryTreeNode {

    private static String NODE_DOES_NOT_ALLOW_CHILDREN_MSG = "node does not allow children";

    private MutableBinaryTreeNode parent;

    private boolean allowsChildren;

    private MutableBinaryTreeNode leftChild;

    private MutableBinaryTreeNode rightChild;

    private Object object;

    public MutableBinaryTreeNodeImpl() {
        this(null, true);
    }

    public MutableBinaryTreeNodeImpl(Object object) {
        this(object, true);
    }

    public MutableBinaryTreeNodeImpl(boolean allowsChildren) {
        this(null, allowsChildren);
    }

    public MutableBinaryTreeNodeImpl(Object object, boolean allowsChildren) {
        this.object = object;
        this.allowsChildren = allowsChildren;
    }

    @Override
    public void setParent(MutableBinaryTreeNode parent) {
        if (parent != null && !parent.allowsChildren()) {
            throw new IllegalStateException("parent " + NODE_DOES_NOT_ALLOW_CHILDREN_MSG);
        }

        this.parent = parent;
    }

    @Override
    public MutableBinaryTreeNode getParent() {
        return parent;
    }

    @Override
    public boolean isRoot() {
        return parent == null;
    }

    @Override
    public void remove(MutableBinaryTreeNode child) {
        if (allowsChildren) {
            if (leftChild == child) {
                leftChild = null;
                child.setParent(null);
            } else if (rightChild == child) {
                rightChild = null;
                child.setParent(null);
            }
        }
    }

    @Override
    public void removeFromParent() {
        if (parent != null) {
            parent.remove(this);
        }
    }

    @Override
    public boolean allowsChildren() {
        return allowsChildren;
    }

    @Override
    public void setLeftChild(MutableBinaryTreeNode leftChild) {
        if (!allowsChildren) {
            throw new IllegalStateException(NODE_DOES_NOT_ALLOW_CHILDREN_MSG);
        }

        leftChild.removeFromParent();
        leftChild.setParent(this);
        this.leftChild = leftChild;
    }

    @Override
    public MutableBinaryTreeNode getLeftChild() {
        return leftChild;
    }

    @Override
    public void setRightChild(MutableBinaryTreeNode rightChild) {
        if (!allowsChildren) {
            throw new IllegalStateException(NODE_DOES_NOT_ALLOW_CHILDREN_MSG);
        }

        rightChild.removeFromParent();
        rightChild.setParent(this);
        this.rightChild = rightChild;
    }

    @Override
    public MutableBinaryTreeNode getRightChild() {
        return rightChild;
    }

    @Override
    public boolean isLeaf() {
        return !allowsChildren || (leftChild == null && rightChild == null);
    }

    @Override
    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object getObject() {
        return object;
    }
}
