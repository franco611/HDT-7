// An implementation of nodes for use in binary trees.
// (c) 1998, 2001 duane a. bailey

import java.lang.Math;
import java.util.Iterator;

public class BinaryTree<E>
{

protected E val; // value associated with node

protected BinaryTree<E> parent; // parent of node

protected BinaryTree<E> left, right; // children of node


public BinaryTree()
        {
        val = null;
        parent = null; left = right = this;
        }


public BinaryTree(E value)
        {
        //Assert.pre(value != null, "Tree values must be non-null.");
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
        }


public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
        {
        //Assert.pre(value != null, "Tree values must be non-null.");
        val = value;
        if (left == null) { left = new BinaryTree<E>(); }
        setLeft(left);
        if (right == null) { right = new BinaryTree<E>(); }
        setRight(right);
        }


public BinaryTree<E> left()
        {
        return left;
        }


public BinaryTree<E> right()
        {
        return right;
        }

public BinaryTree<E> parent()
        {
        return parent;
        }



public void setLeft(BinaryTree<E> newLeft)
        {
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
        }

/**
 * Update the right subtree of this node.  Parent of the right subtree
 * is updated consistently.  Existing subtree is detached
 *
 * @post Sets left subtree to newRight
 *       re-parents newRight if not null
 *
 * @param newRight A reference to the new right subtree of this node
 */
public void setRight(BinaryTree<E> newRight)
        {
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
        }

/**
 * Update the parent of this node
 *
 * @post Re-parents this node to parent reference, or null
 *
 * @param newParent A reference to the new parent of this node
 */
protected void setParent(BinaryTree<E> newParent)
        {
        if (!isEmpty()) {
        parent = newParent;
        }
        }


public int size()
        {
        if (isEmpty()) return 0;
        return left().size() + right().size() + 1;
        }


public BinaryTree<E> root()
        {
        if (parent() == null) return this;
        else return parent().root();
        }



/**
 * Returns true if tree is empty.
 * @post Returns true iff the tree rooted at node is empty
 * @return True iff tree is empty
 */
public boolean isEmpty()
        {
        return val == null;
        }




/**
 * Determine if this node is a left child
 *
 * @post Returns true if this is a left child of parent
 *
 * @return True iff this node is a left child of parent
 */
public boolean isLeftChild()
        {
        if (parent() == null) return false;
        return this == parent().left();
        }

/**
 * Determine if this node is a right child
 *
 * @post Returns true if this is a right child of parent
 *
 * @return True iff this node is a right child of parent
 */
public boolean isRightChild()
        {
        if (parent() == null) return false;
        return this == parent().right();
        }

/**
 * Returns value associated with this node
 *
 * @post Returns value associated with this node
 *
 * @return The node's value
 */
public E value()
        {
        return val;
        }

/**
 * Set's value associated with this node
 *
 * @post Sets the value associated with this node
 * @param value The new value of this node
 */
public void setValue(E value)
        {
        val = value;
        }

/**
 * @post return sum of hashcodes of the contained values
 */
public int hashCode()
        {
        if (isEmpty()) return 0;
        int result = left().hashCode() + right().hashCode();
        if (value() != null) result += value().hashCode();
        return result;
        }

/**
 * Compute the depth of a node.  The depth is the path length
 * from node to root
 *
 * @post Returns the depth of a node in the tree
 * @return The path length to root of tree
 */
public int depth()
        {
        if (parent() == null) return 0;
        return 1 + parent.depth();
        }

/**
 * Returns a string representing the tree rooted at this node.
 * <font color="#FF0000">WARNING</font> this can be a very long string.
 *
 * @return A string representing the tree rooted at this node.
 */
public String treeString(){
        String s = "";
        for (int i=0; i < this.depth(); i++){
        s += "\t|";
        }

        s += ("<" + val + " : " + getHand() + ">\n");

        if (!left.isEmpty()) s += left.treeString();
        if (!right.isEmpty()) s += right.treeString();

        return s;
        }


/**
 * Support method for {@link #toString}. Returns R if this is node
 * is a right child, L if this node is a left child and Root if this
 * node is the root.
 *
 * @return R if this is node
 * is a right child, L if this node is a left child and Root if this
 * node is the root.
 */
private String getHand(){
        if (isRightChild()) return "R";
        if (isLeftChild()) return "L";
        return "Root";
        }


/**
 * Returns a representation the subtree rooted at this node
 *
 * @post Returns string representation
 *
 * @return String representing this subtree
 */
public String toString()
        {
        if (isEmpty()) return "<BinaryTree: empty>";
        StringBuffer s = new StringBuffer();
        s.append("<BinaryTree "+value());
        if (!left().isEmpty()) s.append(" "+left());
        else s.append(" -");
        if (!right().isEmpty()) s.append(" "+right());
        else s.append(" -");
        s.append('>');
        return s.toString();
        }

        public String inorderIterator(BinaryTree nodo){
                if (nodo.isEmpty())
                        return "";
                String res = "";
                res += inorderIterator(nodo.left());
                res += (nodo.value() + " ");
                res += inorderIterator(nodo.right());
                return res;
        }
}