/* @author: esb@hawaii.edu, 2023 */

package edu.ics211.h04;

public class hw04 {

  enum SortType {
    SelectionSort,
    SelectUnique,
    BubbleSort,
    InsertionSort,
  };

  private static void swap(char[] a, int i1, int i2) {
    // student must implement
  }

  static void selectionSort(char[] a) {
    // student must implement
  }

  // like selection sort, but only returns unique elements
  static String selectUnique(char[] a) {
    // student must implement
    return new String(a);  // this string is not sorted!
  }

  static void bubbleSort(char[] a) {
    // student must implement
  }

  static void insertionSort(char[] a) {
    // student must implement
  }

  static String sortChars(String s, SortType sort) {
    char[] a = s.toCharArray();
    switch (sort) {
    case SelectionSort:
      selectionSort(a);
      break;
    case BubbleSort:
      bubbleSort(a);
      break;
    case InsertionSort:
      insertionSort(a);
      break;
    case SelectUnique:
      return selectUnique(a);
    }
    return new String(a);
  }

  public static void main(String[] a) {
    if ((a == null) || (a.length < 1)) {
      a = new String[1];
      a[0] = "the quick brown fox jumps over the lazy dog";
    }
    for (String s: a) {
      System.out.println("'" + s + "' selection sorts to '" +
                         sortChars(s, SortType.SelectionSort) + "'");
      System.out.println("'" + s + "'    bubble sorts to '" +
                         sortChars(s, SortType.BubbleSort) + "'");
      System.out.println("'" + s + "' insertion sorts to '" +
                         sortChars(s, SortType.InsertionSort) + "'");
      System.out.println("'" + s + "' has characters '" +
                         sortChars(s, SortType.SelectUnique) + "'");
    }
  }
}