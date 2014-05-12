import java.io.File;
import java.io.OutputStreamWriter;
import java.net.*;


import javax.net.ssl.HttpsURLConnection;

import com.google.gson.*;

public class cloudAgent {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		fileToSend fts;
		
		File f1 = new File(args[0]);
		if(!f1.exists())
		{
			System.out.println("File Does not exist. Exitting...");
			return;
		}
		else
		{
			fts = new fileToSend(f1.getName(), f1.length(), new File(f1.getAbsolutePath()).getParent());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(fts);
		System.out.println(json);

		URL url = new URL("http://192.168.1.10:8080/api/sendfile");
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();



		httpCon.setRequestProperty("Content-Type", "application/json; charset=utf-8");
	    httpCon.setRequestMethod("PUT");
		httpCon.setDoOutput(true);
		httpCon.setDoInput(true);
		OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
		out.write(json);
		out.flush();
		out.close();
		System.out.println(httpCon.getInputStream());
	}

}
