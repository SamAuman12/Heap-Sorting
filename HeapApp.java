import java.text.BreakIterator;
import java.util.*;

public class HeapApp<E extends Comparable<E>> extends ArrayList<E> {
   // public class HeapApp<E extends Comparable<E>> extends
   // ArrayFullSingleLinkedList<E>{

   public HeapApp() {
      super();
   }

   public String toString() {
      String s = "";
      return infixTravel(0, 1, s);
   }

   private String infixTravel(int localRoot, int depth, String s) {
      // for(int i = 1; i< depth; i++)
      s += "       ";
      if (localRoot > size() - 1)
         return s += "null\n";
      else {
         String str = "";
         str = infixTravel(localRoot * 2 + 1, depth + 1, s);
         str += s + "" + get(localRoot) + "\n";
         str += infixTravel(localRoot * 2 + 2, depth + 1, s);
         return str;
      }
   }

   public HeapApp(E[] data) {
      // must ensure that has been a heap.
      for (int i = 0; i < data.length; i++)
         add(i, data[i]);
   }

   public void heap_item_remove(E item) {
      remove(item);
   }

   public String sorted_out() {
      // return all that is stored in the String
      String s = "";
      while (size() > 2) {
         E element = get(0);
         s += element.toString();
         System.out.print(element);
         heap_top_remove();
         s += "=>";
      }
      s += get(0);
      heap_item_remove(get(0));
      s += "=>";
      s += get(0);
      return s;
   }

   public void heap_item_add(E item) {
      add(item);
      E newElement = get(size() - 1);
      int newIndex = indexOf(newElement);
      E parent = get((newIndex - 1) / 2);
      int parentIndex = indexOf(parent);
      while (newElement.compareTo(parent) < 0 && indexOf(parent) >= 0) {
         set(parentIndex, newElement);
         set(newIndex, parent);
         newIndex = indexOf(newElement);
         parent = get((newIndex - 1) / 2);
         parentIndex = indexOf(parent);
      }
   }

   public String top_value() {
      // Smallest number in the heap
      return get(0).toString();
   }

   public void heap_top_remove() {

      E newBegining = get(size() - 1);
      E smallest = get(0);
      set(0, newBegining);
      set(size() - 1, smallest);
      remove(smallest);
      if (size() > 1 && size() <= 2) {
         System.out.println(indexOf(newBegining));
         System.out.println(size());
         if (newBegining.compareTo(get(indexOf(newBegining) + 1)) > 0) {
            newBegining = get(indexOf(newBegining) - 1);
         }
      } else {
         System.out.println("Root " + newBegining);
         int leftIndex = indexOf(newBegining) * 2 + 1;
         int rightIndex = indexOf(newBegining) * 2 + 2;
         E lChild = get(leftIndex);
         E rChild = get(rightIndex);
         System.out.println("Compare: " + newBegining.compareTo(lChild));
         while ((newBegining.compareTo(lChild) > 0 || newBegining.compareTo(rChild) > 0)
               && indexOf(newBegining) < size()) {
            if (lChild.compareTo(rChild) < 0) {
               if (lChild.compareTo(newBegining) < 0) {
                  set(indexOf(newBegining), lChild);
                  set(leftIndex, newBegining);
                  leftIndex = indexOf(newBegining) * 2 + 1;
                  rightIndex = indexOf(newBegining) * 2 + 2;
                  if (leftIndex > size() - 1 || rightIndex > size() - 1) {
                     break;
                  } else if (get(leftIndex) != null && get(rightIndex) != null) {
                     lChild = get(leftIndex);
                     rChild = get(rightIndex);
                  }
               }
            } else if (rChild.compareTo(newBegining) < 0) {
               set(indexOf(newBegining), rChild);
               set(rightIndex, newBegining);
               System.out.print(size() - 1);
               leftIndex = indexOf(newBegining) * 2 + 1;
               rightIndex = indexOf(newBegining) * 2 + 2;
               if (leftIndex > size() - 1 || rightIndex > size() - 1) {
                  break;
               } else if (get(leftIndex) != null && get(rightIndex) != null) {
                  lChild = get(leftIndex);
                  rChild = get(rightIndex);
               }

            }
         }
      }

   }

}