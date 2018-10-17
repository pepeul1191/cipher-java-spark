package handlers;

import spark.Request;
import spark.Response;
import spark.Route;
import org.json.JSONObject;
import configs.EncryptDecrypt;

public class DecryptHandler{
  public static Route one = (Request request, Response response) -> {
	  String rpta = "";
	  int status = 200;
	  try {
		  String key = request.queryParams("key");
		  String data = request.queryParams("data");
          EncryptDecrypt ed = new EncryptDecrypt(key);
          rpta = ed.decrypt(data);
      } catch (Exception e) {
    	  e.printStackTrace();
          String[] cuerpoMensaje = {"There was an error in decrypting the data", e.toString()};
          JSONObject rptaMensaje = new JSONObject();
          rptaMensaje.put("tipo_mensaje", "error");
          rptaMensaje.put("mensaje", cuerpoMensaje);
          status = 500;
          rpta = rptaMensaje.toString();
      } finally {
    	  response.status(status);
    	  return rpta;
      }
  };
}