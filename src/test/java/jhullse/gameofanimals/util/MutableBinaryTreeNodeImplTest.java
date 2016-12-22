package jhullse.gameofanimals.util;

import org.junit.Assert;
import org.junit.Test;

public class MutableBinaryTreeNodeImplTest {

    @Test(expected = IllegalStateException.class)
    public void setParent_Should_ThrowIllegalStateException_When_ParentDoesNotAllowChildren() {
        MutableBinaryTreeNodeImpl parent = new MutableBinaryTreeNodeImpl(false);
        MutableBinaryTreeNodeImpl child =  new MutableBinaryTreeNodeImpl();

        child.setParent(parent);
    }

    @Test
    public void isRoot_Should_BeFalse_When_ChildHasParent() {
        MutableBinaryTreeNodeImpl parent = new MutableBinaryTreeNodeImpl();
        MutableBinaryTreeNodeImpl child = new MutableBinaryTreeNodeImpl();

        child.setParent(parent);

        Assert.assertFalse(child.isRoot());
    }

    @Test
    public void isRoot_Should_BeTrue_When_ChildHasNoParent() {
        MutableBinaryTreeNodeImpl child = new MutableBinaryTreeNodeImpl();

        Assert.assertTrue(child.isRoot());
    }

    @Test(expected = IllegalStateException.class)
    public void setLeftChild_Should_ThrowIllegalStateException_When_ParentDoesNotAllowChildren() {
        MutableBinaryTreeNodeImpl parent = new MutableBinaryTreeNodeImpl(false);
        MutableBinaryTreeNodeImpl child = new MutableBinaryTreeNodeImpl();

        parent.setLeftChild(child);
    }

    @Test
    public void setLeftChild_Should_RemoveOldParentFromChild_And_UpdateNewParent() {
        MutableBinaryTreeNodeImpl oldParent = new MutableBinaryTreeNodeImpl();
        MutableBinaryTreeNodeImpl child = new MutableBinaryTreeNodeImpl();
        MutableBinaryTreeNodeImpl newParent = new MutableBinaryTreeNodeImpl();

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
        MutableBinaryTreeNodeImpl parent = new MutableBinaryTreeNodeImpl(false);
        MutableBinaryTreeNodeImpl child = new MutableBinaryTreeNodeImpl();

        parent.setRightChild(child);
    }

    @Test
    public void setRightChild_Should_RemoveOldParentFromChild_And_UpdateNewParent() {
        MutableBinaryTreeNodeImpl oldParent = new MutableBinaryTreeNodeImpl();
        MutableBinaryTreeNodeImpl child = new MutableBinaryTreeNodeImpl();
        MutableBinaryTreeNodeImpl newParent = new MutableBinaryTreeNodeImpl();

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
        MutableBinaryTreeNodeImpl node = new MutableBinaryTreeNodeImpl(false);

        Assert.assertTrue(node.isLeaf());
    }

    @Test
    public void isLeaf_Should_BeTrue_When_NodeAllowChildren_And_NodeHasNoChildren() {
        MutableBinaryTreeNodeImpl node = new MutableBinaryTreeNodeImpl();

        Assert.assertTrue(node.isLeaf());
    }

    @Test
    public void isLeaf_Should_BeFalse_When_NodeHasChildren() {
        MutableBinaryTreeNodeImpl parent = new MutableBinaryTreeNodeImpl();
        MutableBinaryTreeNodeImpl leftChild = new MutableBinaryTreeNodeImpl();
        MutableBinaryTreeNodeImpl rightChild = new MutableBinaryTreeNodeImpl();

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

        MutableBinaryTreeNodeImpl node = new MutableBinaryTreeNodeImpl(oldObject);
        Assert.assertEquals(node.getObject(), oldObject);

        node.setObject(newObject);
        Assert.assertEquals(node.getObject(), newObject);
    }
}
