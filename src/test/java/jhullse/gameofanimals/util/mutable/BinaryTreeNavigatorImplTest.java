package jhullse.gameofanimals.util.mutable;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeNavigatorImplTest {

    @Test
    public void setRoot_Should_UpdateRootNode_When_ItWasAlreadySet() {
        BinaryTreeNodeImpl oldParent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl newParent = new BinaryTreeNodeImpl();

        BinaryTreeNavigatorImpl navigator = new BinaryTreeNavigatorImpl();
        navigator.setRoot(oldParent);
        Assert.assertEquals(navigator.getRoot(), oldParent);

        navigator.setRoot(newParent);
        Assert.assertEquals(navigator.getRoot(), newParent);
    }

    @Test
    public void next_Should_ReturnLeftChild_When_ParameterIsTrue() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl leftChild = new BinaryTreeNodeImpl();

        parent.setLeftChild(leftChild);

        BinaryTreeNavigatorImpl navigator = new BinaryTreeNavigatorImpl(parent);

        Assert.assertEquals(navigator.next(true), leftChild);
    }

    @Test
    public void next_Should_ReturnRightChild_When_ParameterIsFalse() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl rightChild = new BinaryTreeNodeImpl();

        parent.setRightChild(rightChild);

        BinaryTreeNavigatorImpl navigator = new BinaryTreeNavigatorImpl(parent);

        Assert.assertEquals(navigator.next(false), rightChild);
    }

    @Test
    public void next_Should_ReturnNull_When_ThereIsNoChild() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl();
        BinaryTreeNavigatorImpl navigator = new BinaryTreeNavigatorImpl(parent);

        Assert.assertNull(navigator.next(true));
        Assert.assertNull(navigator.next(false));
    }

    @Test
    public void rewind_Should_ChangeCurrentNodeToRoot() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl leftChild = new BinaryTreeNodeImpl();

        parent.setLeftChild(leftChild);
        BinaryTreeNavigatorImpl navigator = new BinaryTreeNavigatorImpl(parent);

        Assert.assertEquals(navigator.next(true), leftChild);
        Assert.assertEquals(navigator.getCurrent(), leftChild);

        navigator.rewind();

        Assert.assertEquals(navigator.getCurrent(), parent);
    }
}
