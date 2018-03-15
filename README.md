## Project Info

This project is a wrapper of the Utopian APIs in Java. Java Developers can use this tool to call Utopian APIs easily.

## Technology Stack

[Java 9](https://www.oracle.com/java/java9.html)

## License

MIT

## Features

List moderators

List sponsors

Check if an user is a moderator

Check if an user is a sponsor

Get all posts satisfying given criteria

Get a particular post information

Check Utopian bot stats

Check if Utopian bot is voting

## Test

All provided methods are tested with JUnit test cases:

https://github.com/aa-feng/utopianj/blob/master/src/test/java/io/utopian/UtopianJTest.java

## How to use it?

This project is managed by Maven. After git clone this project to your PC, assuming you have installed Maven, then run the following commands:

### Install this project to your local Maven repository

```bash
mvn install 
```

### Use this project

Add this project in your pom.xml, e.g.:

```xml
    <dependency>
      <groupId>com.aafeng</groupId>
      <artifactId>utopianj</artifactId>
      <version>0.1</version>
    </dependency>
```

Then, you can use it:

```java
import com.aafeng.UtopianJ

UtopianJ.getModerators();
UtopianJ.isModerator("espoem")
UtopianJ.getSponsors();
UtopianJ.isSponsor("espoem")

MultivaluedMap<String,String> params = new MultivaluedHashMap<String,String>();
params.add("limit","1");
JSONObject posts = UtopianJ.getPosts(params);

UtopianJ.getPost("espoem","sidebar-in-the-post-jumps-to-the-top-of-the-page")

UtopianJ.getStats()

UtopianJ.isVoting()
```

## Roadmap

The following features will be added:

* More information about moderators, e.g. payouts, 

* Information about Utopian categories

* Add relevant Java class, e.g. Moderator, Category, Post, to make this tool more Developer friendly

## How to contribute

Github: https://github.com/aa-feng/utopianj

Just fork this project, create your feature branch, and send a pull request.

