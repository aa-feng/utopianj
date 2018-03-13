package io.utopian;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MultivaluedHashMap;
import org.json.JSONObject;

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
   * return moderator lists as a JSON string
   */
  public static JSONObject getModerators() {
    //MultivaluedMap<String,String> params = new MultivaluedHashMap<String,String>();
    //params.add("limit", "1");
    return connect("moderators",null);
  }

  /**
   * return sponsor list as a JSON string
   */
  public static String getSponsors() {

    return null;
  }  

  /**
   * check if an account is a moderator
   */
  public static boolean isModerator(String account) {

    return false;
  }

  /**
   * check if an account is a sponsor
   */
  public static boolean isSponsor(String account) {

    return false;
  }

  /** 
   * return Utopian posts determined by the query parameters
   */
  public static String getPosts(MultivaluedMap<String,String> params) {

    return null;
  }

  /**
   * return a post String 
   */
  public static String getPost(String author, String permlink) {

    return null;
  }

  /**
   * return the current status of utopian.io
   */
  public static String getStats() {

    return null;
  }

  /**
   * check if Bot is voting
   */
  public static boolean isVoting() {

    return false;
  }

}
