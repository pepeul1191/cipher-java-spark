package handlers;

import spark.Request;
import spark.Response;
import spark.Route;
import org.apache.commons.lang3.RandomStringUtils;

public class KeyHandler{
  public static Route generate = (Request request, Response response) -> {
	 return RandomStringUtils.randomAlphabetic(16);
  };
}