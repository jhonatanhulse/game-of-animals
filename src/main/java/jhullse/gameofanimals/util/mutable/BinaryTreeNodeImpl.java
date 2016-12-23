package jhullse.gameofanimals.util.mutable;

public class BinaryTreeNodeImpl implements BinaryTreeNode {

    private static String NODE_DOES_NOT_ALLOW_CHILDREN_MSG = "node does not allow children";

    private BinaryTreeNode parent;

    private boolean allowsChildren;

    private BinaryTreeNode leftChild;

    private BinaryTreeNode rightChild;

    private Object object;

    public BinaryTreeNodeImpl() {
        this(null, true);
    }

    public BinaryTreeNodeImpl(Object object) {
        this(object, true);
    }

    public BinaryTreeNodeImpl(boolean allowsChildren) {
        this(null, allowsChildren);
    }

    public BinaryTreeNodeImpl(Object object, boolean allowsChildren) {
        this.object = object;
        this.allowsChildren = allowsChildren;
    }

    @Override
    public void setParent(BinaryTreeNode parent) {
        if (parent != null && !parent.allowsChildren()) {
            throw new IllegalStateException("parent " + NODE_DOES_NOT_ALLOW_CHILDREN_MSG);
        }

        this.parent = parent;
    }

    @Override
    public BinaryTreeNode getParent() {
        return parent;
    }

    @Override
    public boolean isRoot() {
        return parent == null;
    }

    @Override
    public void remove(BinaryTreeNode child) {
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
    public void setLeftChild(BinaryTreeNode leftChild) {
        if (!allowsChildren) {
            throw new IllegalStateException(NODE_DOES_NOT_ALLOW_CHILDREN_MSG);
        }

        leftChild.removeFromParent();
        leftChild.setParent(this);
        this.leftChild = leftChild;
    }

    @Override
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    @Override
    public void setRightChild(BinaryTreeNode rightChild) {
        if (!allowsChildren) {
            throw new IllegalStateException(NODE_DOES_NOT_ALLOW_CHILDREN_MSG);
        }

        rightChild.removeFromParent();
        rightChild.setParent(this);
        this.rightChild = rightChild;
    }

    @Override
    public BinaryTreeNode getRightChild() {
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
