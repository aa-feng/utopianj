package com.aafeng;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MultivaluedHashMap;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Utopian API Java Client
 *
 */
public class UtopianJ {

  public static String baseUrl = "https://api.utopian.io/api/";

  public static JSONObject connect(String path, MultivaluedMap<String,String> params) {
    Client client = Client.create();
    WebResource webResource = client.resource(baseUrl);
    ClientResponse response = null;
    if(params==null) {
      response = webResource.path(path).accept("application/json").get(ClientResponse.class);
    }else{
      response = webResource.path(path).queryParams(params).accept("application/json").get(ClientResponse.class);
    }
    if (response.getStatus() != 200) {
       throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }
    return new JSONObject(response.getEntity(String.class));
  }


  /**
   * return moderators as a JSONObject
   */
  public static JSONObject getModerators() {
    return connect("moderators",null);
  }

  /**
   * return sponsors as a JSONObject
   */
  public static JSONObject getSponsors() {
    return connect("sponsors",null);
  }  

  /**
   * check if an account is a moderator
   */
  public static boolean isModerator(String account) {
    JSONArray moderators = getModerators().getJSONArray("results");
    for (int i=0; i<moderators.length(); i++) {
      if(account.equals(moderators.getJSONObject(i).getString("account")))
        return true;
    }
    return false;
  }

  /**
   * check if an account is a supervisor
   */
  public static boolean isSupervisor(String account) {
    JSONArray moderators = getModerators().getJSONArray("results");
    for (int i=0; i<moderators.length(); i++) {
      if(account.equals(moderators.getJSONObject(i).getString("account")) &&
         moderators.getJSONObject(i).getBoolean("supermoderator"))
        return true;
    }
    return false;
  }


  /**
   * check if an account is a sponsor
   */
  public static boolean isSponsor(String account) {
    JSONArray sponsors = getSponsors().getJSONArray("results");
    for (int i=0; i<sponsors.length(); i++) {
      if(account.equals(sponsors.getJSONObject(i).getString("account")))
        return true;
    }
    return false;
  }

  /** 
   * return Utopian posts determined by the query parameters
   */
  public static JSONObject getPosts(MultivaluedMap<String,String> params) {
    return connect("posts", params);
  }

  /**
   * return a post JSONObject 
   */
  public static JSONObject getPost(String author, String permlink) {
    return connect("posts/"+author+"/"+permlink, null);
  }

  /**
   * return the current status of utopian.io
   */
  public static JSONObject getStats() {
    return connect("stats", null);
  }

  /**
   * check if Bot is voting
   */
  public static boolean isVoting() {
    return getStats().getJSONObject("stats").getBoolean("bot_is_voting");
  }

}
