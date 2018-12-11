import java.io.*;

public class BinarySearchTree<T extends Comparable<T> > 
{
   private BSTNode<T> root;

   public BinarySearchTree()
   {
      root = null;
   }

   public void displayElements(PrintWriter p)
   {
      displaySubtreeInOrder(root, p);
   }

   private void displaySubtreeInOrder(BSTNode<T> localRoot, PrintWriter p)
   {
      if(localRoot.getLeftChild() != null)
      {
         displaySubtreeInOrder(localRoot.getLeftChild(),p);
      }
      p.println(localRoot.getData());
      if(localRoot.getRightChild() != null)
      {
         displaySubtreeInOrder(localRoot.getRightChild(),p);
      }
   }

   public boolean insertElement(T data)
   {
      if(root == null)
      {
         root = new BSTNode<T>(data);
         return true;
      }

      BSTNode<T> temp = root;
      while(true)
      {
         if((data.compareTo(temp.getData()) <= 0) && (temp.getLeftChild() != null))
         {
            temp = temp.getLeftChild();
         }else if((data.compareTo(temp.getData()) > 0) && (temp.getRightChild() != null))
         {
            temp = temp.getRightChild();
         }else
         {
            break;
         }
      }

      BSTNode<T> newNode = new BSTNode<T>(data);
         if((data.compareTo(temp.getData()) <= 0))
         {
            temp.setLeftChild(newNode);
         }else
         {
            temp.setRightChild(newNode);
         }
      return true;
   }

   public T contains(T data)
   {

      if(root == null)
      {
         return null;
      }

      BSTNode<T> temp = root;
      while(true)
      {
         if(data.compareTo(temp.getData()) == 0)
         {
            return temp.getData();
         }else if((data.compareTo(temp.getData()) < 0) && (temp.getLeftChild() != null))
         {
            temp = temp.getLeftChild();
         }else if((data.compareTo(temp.getData()) > 0) && (temp.getRightChild() != null))
         {
            temp = temp.getRightChild();
         }else
         {
            return null;
         }
      }
   }

   public boolean removeElement(T data)
   {
      if(root == null)
      {
         return false;
      }
      BSTNode<T> deleted = root;
      BSTNode<T> parent = null;

      while(true)
      {
         if(data.compareTo(deleted.getData()) == 0)
         {
            break;
         }else if((data.compareTo(deleted.getData()) < 0) && (deleted.getLeftChild() != null))
         {
            parent = deleted;
            deleted = deleted.getLeftChild();
         }else if((data.compareTo(deleted.getData()) > 0) && (deleted.getRightChild() != null))
         {
            parent = deleted;
            deleted = deleted.getRightChild();
         }else
         {
            return false;
         }
      }
      if((deleted.getLeftChild() == null) && (deleted.getRightChild() == null))
      {
         return deleteLeafNode(deleted,parent);
      }else if((deleted.getLeftChild() != null) && deleted.getRightChild() != null)
      {
         return deleteNodeWith2Children(deleted);
      }else
      {
         return deleteNodeWithOneChild(deleted,parent);
      }
   }
   public boolean deleteLeafNode(BSTNode<T> deleted, BSTNode<T> parent)
   {
      if(parent == null) //if the node to be deleted is the root node, parent will be null
      {
         root = null;
      }else if(parent.getLeftChild() == deleted)
      {
         parent.setLeftChild(null);
      }else
      {
         parent.setRightChild(null);
      }
      return true;
   }

   public boolean deleteNodeWithOneChild(BSTNode<T> deleted, BSTNode<T> parent)
   {
      BSTNode<T> child;
      if(deleted.getLeftChild() != null) //if node has a left child
      {
         child = deleted.getLeftChild();
      }else //otherwise, it will have a right child
      {
         child = deleted.getRightChild();
      }

      if(deleted == root)
      {
         root = child;
      }else if(parent.getLeftChild() == deleted)
      {
         parent.setLeftChild(child);
      }else
      {
         parent.setRightChild(child);
      }
      return true;
   }

   public boolean deleteNodeWith2Children(BSTNode<T> deleted)
   {
      BSTNode<T> largest = deleted.getLeftChild();
      BSTNode<T> pOfLargest = deleted;
      while(largest.getRightChild() != null) //looking for children on the right
      {
         pOfLargest = largest;
         largest = largest.getRightChild();
      }
      deleted.setData(largest.getData());

      if(largest.getLeftChild() == null)
      {
         return deleteLeafNode(largest, pOfLargest);
      }else
      {
         return deleteNodeWithOneChild(largest, pOfLargest);
      }
   }
}

