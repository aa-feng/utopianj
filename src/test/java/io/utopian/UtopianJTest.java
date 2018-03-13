package io.utopian;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;

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
  public void testGetModerators() {
    JSONObject moderators = UtopianJ.getModerators(); 
    assertNotNull(moderators.getJSONArray("results").getJSONObject(0).getString("account"));
  }

  @Test
  public void testIsModerator() {
    assertTrue(UtopianJ.isModerator("espoem"));
  }

  @Test
  public void testGetSponsors() {
    JSONObject sponsors = UtopianJ.getSponsors();
    assertNotNull(sponsors.getJSONArray("results").getJSONObject(0).getString("account"));
  }


}
