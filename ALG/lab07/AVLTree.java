import java.io.PrintWriter;

public class AVLTree<T extends Comparable<T> >
{
   private AVLNode<T> root;

   public AVLTree()
   {
      root = null;   
   }

   public void displayElements(PrintWriter p)
   {
      displaySubtreeInOrder(root, p);
   }

   private void displaySubtreePrefixOrder(AVLNode<T> localRoot, PrintWriter p)
   {
      if (localRoot != null)
      {
         p.println(localRoot.getData());
         displaySubtreePrefixOrder(localRoot.getLeftChild(), p);
         displaySubtreePrefixOrder(localRoot.getRightChild(), p);
      }
   }

   public boolean insertElement(T data)
   {
      root = insertElement(root, data);
      return true;
   }

   private int height(AVLNode<T> localRoot)
   {
      if (localRoot == null) 
      {
         return -1;
      }
      else
      {
         return localRoot.getHeight();
      }
   }

   private AVLNode<T> insertElement(AVLNode<T> localRoot, T data)
   {
      if (localRoot == null)
      {
         localRoot = new AVLNode<T>(data);
      }
      else if (data.compareTo(localRoot.getData()) < 0)
      {
         AVLNode<T> leftChild = localRoot.getLeftChild();
         AVLNode<T> subtree = insertElement(leftChild, data);
         localRoot.setLeftChild(subtree);
         localRoot = rebalance(localRoot);
      }
      else 
      {
         AVLNode<T> rightChild = localRoot.getRightChild();
         AVLNode<T> subtree = insertElement(rightChild, data);
         localRoot.setRightChild(subtree);
         localRoot = rebalance(localRoot);
      }

      setHeight(localRoot);
      return localRoot;
   }

   private void setHeight(AVLNode<T> localRoot)
   {
      if (height(localRoot.getLeftChild()) > height(localRoot.getRightChild()))
      {
         localRoot.setHeight(height(localRoot.getLeftChild()) + 1);
      }
      else
      {
         localRoot.setHeight(height(localRoot.getRightChild()) + 1);
      }
   }

   public boolean removeElement(T data)
   {
      // not implemented
      return false;
   }

   public T contains(T searchElement)
   {
      boolean found = false;
      AVLNode<T> current = root;
      T temp = null;

      while (current != null && !found)
      {
         if (current.getData().compareTo(searchElement) > 0)
         {
            current = current.getLeftChild();
         }
         else if (current.getData().compareTo(searchElement) < 0)
         {
            current = current.getRightChild();
         }
         else
         {
            temp = current.getData();
            found = true;
         }
      }
      return temp;
   }

   private AVLNode<T> rightRotation(AVLNode<T> node)
   {
      AVLNode<T> p = node.getLeftChild();
      AVLNode<T> rcp = p.getRightChild();
      p.setRightChild(node);
      node.setLeftChild(rcp);
      setHeight(node);  //Height of node may have changed
      setHeight(p);
      return p;          //This node is now at the top of the local tree
   }

   private AVLNode<T> leftRotation(AVLNode<T> node)
   {
      AVLNode<T> p = node.getRightChild();
      AVLNode<T> lcp = p.getLeftChild();
      p.setLeftChild(node);
      node.setRightChild(lcp);
      setHeight(node);
      setHeight(p);
      return p;
   }

   private AVLNode<T> rightLeftRotation(AVLNode<T> node)
   {
      AVLNode<T> p = node.getRightChild();
      node.setRightChild(rightRotation(p));
      return leftRotation(node);
   }

   private AVLNode<T> leftRightRotation(AVLNode<T> node)
   {
      AVLNode<T> p = node.getLeftChild();
      node.setLeftChild(leftRotation(p));
      return rightRotation(node);
   }

   private int getHeightDifference(AVLNode<T> node)
   {
      int leftH,rightH;
      if(node.getLeftChild() == null)
      {
         leftH = -1;
      }else
      {
         leftH = node.getLeftChild().getHeight();
      }

      if(node.getRightChild() == null)
      {
         rightH = -1;
      }else
      {
         rightH = node.getRightChild().getHeight();
      }
      return leftH - rightH;
   }

   private AVLNode<T> rebalance(AVLNode<T> localRoot)
   {
      AVLNode<T> newRoot = localRoot;
      int diffHeight = getHeightDifference(localRoot);
      if (diffHeight == 2)
      {
         if(getHeightDifference(localRoot.getLeftChild()) == -1)
         {
            newRoot = leftRightRotation(localRoot);
         }else
         {
            newRoot = rightRotation(localRoot);
         }
      }else if(diffHeight == -2)
      {
         if(getHeightDifference(localRoot.getRightChild()) == 1)
         {
            newRoot = rightLeftRotation(localRoot);
         }else
         {
            newRoot = leftRotation(localRoot);
         }
      }
      return newRoot;
   }

   private void displaySubtreeInOrder(AVLNode<T> localRoot, PrintWriter p)
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
}
