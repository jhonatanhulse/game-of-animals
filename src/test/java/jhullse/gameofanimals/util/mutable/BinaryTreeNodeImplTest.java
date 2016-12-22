package jhullse.gameofanimals.util.mutable;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeNodeImplTest {

    @Test(expected = IllegalStateException.class)
    public void setParent_Should_ThrowIllegalStateException_When_ParentDoesNotAllowChildren() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl(false);
        BinaryTreeNodeImpl child =  new BinaryTreeNodeImpl();

        child.setParent(parent);
    }

    @Test
    public void isRoot_Should_BeFalse_When_ChildHasParent() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl child = new BinaryTreeNodeImpl();

        child.setParent(parent);

        Assert.assertFalse(child.isRoot());
    }

    @Test
    public void isRoot_Should_BeTrue_When_ChildHasNoParent() {
        BinaryTreeNodeImpl child = new BinaryTreeNodeImpl();

        Assert.assertTrue(child.isRoot());
    }

    @Test(expected = IllegalStateException.class)
    public void setLeftChild_Should_ThrowIllegalStateException_When_ParentDoesNotAllowChildren() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl(false);
        BinaryTreeNodeImpl child = new BinaryTreeNodeImpl();

        parent.setLeftChild(child);
    }

    @Test
    public void setLeftChild_Should_RemoveOldParentFromChild_And_UpdateNewParent() {
        BinaryTreeNodeImpl oldParent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl child = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl newParent = new BinaryTreeNodeImpl();

        oldParent.setLeftChild(child);

        Assert.assertEquals(child.getParent(), oldParent);
        Assert.assertEquals(oldParent.getLeftChild(), child);

        newParent.setLeftChild(child);

        Assert.assertNotEquals(child.getParent(), oldParent);
        Assert.assertNotEquals(oldParent.getLeftChild(), child);
        Assert.assertEquals(child.getParent(), newParent);
        Assert.assertEquals(newParent.getLeftChild(), child);
    }

    @Test(expected = IllegalStateException.class)
    public void setRightChild_Should_ThrowIllegalStateException_When_ParentDoesNotAllowChildren() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl(false);
        BinaryTreeNodeImpl child = new BinaryTreeNodeImpl();

        parent.setRightChild(child);
    }

    @Test
    public void setRightChild_Should_RemoveOldParentFromChild_And_UpdateNewParent() {
        BinaryTreeNodeImpl oldParent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl child = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl newParent = new BinaryTreeNodeImpl();

        oldParent.setRightChild(child);

        Assert.assertEquals(child.getParent(), oldParent);
        Assert.assertEquals(oldParent.getRightChild(), child);

        newParent.setRightChild(child);

        Assert.assertNotEquals(child.getParent(), oldParent);
        Assert.assertNotEquals(oldParent.getRightChild(), child);
        Assert.assertEquals(child.getParent(), newParent);
        Assert.assertEquals(newParent.getRightChild(), child);
    }

    @Test
    public void isLeaf_Should_BeTrue_When_NodeDoesNotAllowChildren() {
        BinaryTreeNodeImpl node = new BinaryTreeNodeImpl(false);

        Assert.assertTrue(node.isLeaf());
    }

    @Test
    public void isLeaf_Should_BeTrue_When_NodeAllowChildren_And_NodeHasNoChildren() {
        BinaryTreeNodeImpl node = new BinaryTreeNodeImpl();

        Assert.assertTrue(node.isLeaf());
    }

    @Test
    public void isLeaf_Should_BeFalse_When_NodeHasChildren() {
        BinaryTreeNodeImpl parent = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl leftChild = new BinaryTreeNodeImpl();
        BinaryTreeNodeImpl rightChild = new BinaryTreeNodeImpl();

        parent.setLeftChild(leftChild);
        Assert.assertFalse(parent.isLeaf());
        parent.remove(leftChild);

        parent.setRightChild(rightChild);
        Assert.assertFalse(parent.isLeaf());
        parent.remove(rightChild);

        Assert.assertTrue(parent.isLeaf());

        parent.setLeftChild(leftChild);
        parent.setRightChild(rightChild);
        Assert.assertFalse(parent.isLeaf());
    }

    @Test
    public void setObject_Should_UpdateObject_When_ItWasAlreadySet() {
        Object oldObject = new Object();
        Object newObject = new Object();

        BinaryTreeNodeImpl node = new BinaryTreeNodeImpl(oldObject);
        Assert.assertEquals(node.getObject(), oldObject);

        node.setObject(newObject);
        Assert.assertEquals(node.getObject(), newObject);
    }
}
