package io.utopian;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for UtopianJ.
 */
public class UtopianJTest {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testModerators() {
    System.out.println(UtopianJ.getModerators());
  }


}
