import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals("Testing merge right end",expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b");
    List<String> right = Arrays.asList("d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "d");
    assertEquals("Testing Merge left end", expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeSame() {
    List<String> left = Arrays.asList("a", "a", "a", "a");
    List<String> right = Arrays.asList("a", "a");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "a", "a", "a", "a");
    assertEquals("Testing Merge same",expected, merged);
  } 

  @Test(timeout = 500)
  public void testMergeMoon() {
    List<String> left = Arrays.asList("a", "b", "moon");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "d", "moon");
    assertEquals("Testing Merge moon",expected, merged);
  } 
}

