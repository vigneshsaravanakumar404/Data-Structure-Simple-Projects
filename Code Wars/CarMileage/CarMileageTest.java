import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarMileageTest {

  @Test
  public void testTooSmall() {
    assertEquals(0, CarMileage.isInteresting(3, new int[] { 1337, 256 }));
  }

  @Test
  public void testAlmostAwesome() {
    assertEquals(1, CarMileage.isInteresting(1336, new int[] { 1337, 256 }));
  }

  @Test
  public void testAwesome() {
    assertEquals(2, CarMileage.isInteresting(1337, new int[] { 1337, 256 }));
  }

  @Test
  public void testFarNotInteresting() {
    assertEquals(0, CarMileage.isInteresting(11208, new int[] { 1337, 256 }));
  }

  @Test
  public void testAlmostInteresting() {
    assertEquals(1, CarMileage.isInteresting(11209, new int[] { 1337, 256 }));
  }

  @Test
  public void testInteresting() {
    assertEquals(2, CarMileage.isInteresting(11211, new int[] { 1337, 256 }));
  }

  public static void main(String[] args) {

    System.out.println(CarMileage.isInteresting(1232, new int[] { 1337, 256 }));
    System.out.println(CarMileage.isInteresting(4321, new int[] { 1337, 256 }));

    System.out.println(CarMileage.isInteresting(4320, new int[] { 1337, 256 }));
    System.out.println(CarMileage.isInteresting(4319, new int[] { 1337, 256 }));
  }

}