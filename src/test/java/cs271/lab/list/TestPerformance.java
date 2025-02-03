package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // TODO Question: What conclusions can you draw about the performance of LinkedList vs. ArrayList when
  // comparing their running times for AddRemove vs. Access? Record those running times in README.txt!
  // TODO (optional) refactor to DRY
  // which of the two lists performs better as the size increases?
  private final int SIZE = 10;
  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private final int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }
  private long recordTime(Runnable test) {
    long startTime = System.nanoTime();
    test.run();
    return System.nanoTime() - startTime;
  }
  @Test
  public void testLinkedListAddRemove() {
    long startTime = System.nanoTime();
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
      }
      long endTime = System.nanoTime();
      System.out.println("LinkedList Add/Remove Time: " + (endTime - startTime) + " ns");

  }

  @Test
  public void testArrayListAddRemove() {
    long startTime = System.nanoTime();
    for (var r = 0; r < REPS; r++) {
      arrayList.add(0, 77); // Adding at the beginning
      arrayList.remove(0);  // Removing from the beginning
    }
    long endTime = System.nanoTime();
    System.out.println("ArrayList Add/Remove Time: " + (endTime - startTime) + " ns");
  }

  @Test
  public void testLinkedListAccess() {
    var sum = 0L;
    long startTime = System.nanoTime();
    for (var r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);  // Accessing elements in a round-robin fashion
    }
    long endTime = System.nanoTime();
    System.out.println("LinkedList Access Time: " + (endTime - startTime) + " ns");
  }

  @Test
  public void testArrayListAccess() {
    var sum = 0L;
    long startTime = System.nanoTime();
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);  // Accessing elements in a round-robin fashion
    }
    long endTime = System.nanoTime();
    System.out.println("ArrayList Access Time: " + (endTime - startTime) + " ns");
  }
  @Test
  public void testPerformanceWithDifferentSizes() {
    // Try different sizes and run the performance tests for each
    int[] sizes = {10, 100, 1000, 10000};
    for (int size : sizes) {
      System.out.println("Running tests for SIZE = " + size);

      // Resize the lists accordingly
      arrayList = new ArrayList<>(size);
      linkedList = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        arrayList.add(i);
        linkedList.add(i);
      }

      // Test Add/Remove
      long linkedListAddRemoveTime = recordTime(() -> {
        for (var r = 0; r < REPS; r++) {
          linkedList.add(0, 77);
          linkedList.remove(0);
        }
      });
      long arrayListAddRemoveTime = recordTime(() -> {
        for (var r = 0; r < REPS; r++) {
          arrayList.add(0, 77);
          arrayList.remove(0);
        }
      });

      // Test Access
      long linkedListAccessTime = recordTime(() -> {
        long sum = 0L;
        for (var r = 0; r < REPS; r++) {
          sum += linkedList.get(r % size);
        }
      });
      long arrayListAccessTime = recordTime(() -> {
        long sum = 0L;
        for (var r = 0; r < REPS; r++) {
          sum += arrayList.get(r % size);
        }
      });

      // Output the results
      System.out.printf("SIZE = %d\n", size);
      System.out.printf("LinkedList Add/Remove Time: %d ns\n", linkedListAddRemoveTime);
      System.out.printf("ArrayList Add/Remove Time: %d ns\n", arrayListAddRemoveTime);
      System.out.printf("LinkedList Access Time: %d ns\n", linkedListAccessTime);
      System.out.printf("ArrayList Access Time: %d ns\n", arrayListAccessTime);
      System.out.println("-----------------------------------");
    }
  }

}
