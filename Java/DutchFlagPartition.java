import java.util.*;

public class DutchFlagPartition{
  public static enum Color {RED, WHITE, BLUE}

  public static void dutchFlagPartition(int pivotIndex, List<Integer> A){
    int pivot = A.get(pivotIndex);
    /**
    * Invariants:
    * bottom group: A.subList(0,smaller)
    * middle group: A.subList(smaller, equal)
    * unclassified group: A.sublist(equal, larger)
    * top group: A.subList(larger, A.size())
    */
    int smaller = 0;
    int equal = 0;
    int larger = A.size();

    while (equal < larger){
      if(A.get(equal) < pivot){
        Collections.swap(A, smaller++, equal++);
      }
      else if(A.get(equal) == pivot){
        ++equal;
      }
      else{ //A.get(equal) > pivot
        Collections.swap(A, equal, --larger);
      }
    }

  }

  public static void main(String arg[]){
    List<Integer> A = new ArrayList<>();
    A.add(0);
    A.add(1);
    A.add(2);
    A.add(0);
    A.add(2);
    A.add(1);

    A.add(1);

    dutchFlagPartition(2, A);
    for(int i = 0 ; i < A.size() ; i++){
      System.out.println(A.get(i));
    }
    System.out.println();
    dutchFlagPartition(3, A);
    for(int i = 0 ; i < A.size() ; i++){
      System.out.println(A.get(i));
    }

  }
}
