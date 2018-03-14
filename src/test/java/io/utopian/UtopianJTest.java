package com.aafeng;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MultivaluedHashMap;

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

  @Test
  public void testIsSponsor() {
    assertTrue(UtopianJ.isSponsor("espoem"));
  }

  @Test
  public void testGetPosts() {
    MultivaluedMap<String,String> params = new MultivaluedHashMap<String,String>();
    params.add("limit","1");
    JSONObject posts = UtopianJ.getPosts(params);
    assertNotNull(posts.getJSONArray("results").getJSONObject(0).getString("author"));
  }

  @Test
  public void testGetPost() {
    assertNotNull(UtopianJ.getPost("espoem","sidebar-in-the-post-jumps-to-the-top-of-the-page").getString("title"));
  }

  @Test
  public void testGetStatus() {
    assertNotNull(UtopianJ.getStats());
  }

  @Test
  public void testIsVoting() {
    boolean isVoting = UtopianJ.isVoting();
    assertTrue(isVoting==true||isVoting==false);
  }

}
