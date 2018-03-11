package io.utopian;

import java.util.Map;

/**
 * Utopian API Java Client
 *
 */
public class UtopianJ {

  public static String baseUrl = "https://api.utopian.io/api/";

  /**
   * return moderator lists as a JSON string
   */
  public static String getModerators() {

    return null;
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
  public static String getPosts(Map<String,String> params) {

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
