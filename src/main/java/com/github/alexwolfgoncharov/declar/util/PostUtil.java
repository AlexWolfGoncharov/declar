package com.github.alexwolfgoncharov.declar.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by alexwolf on 26.02.16.
 */
public class PostUtil {


    private static final Logger log = Logger.getLogger(PostUtil.class
            .getName());


    public   String sendPost(String send) throws Exception {

        String USER_AGENT = "Mozilla/5.0";

        String url = "https://iq.privatbank.ua/488";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Content-Type:", "text/xml");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");



        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(send);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        log.info("\nSending 'POST' request to URL : " + url);
        log.info("Post parameters : " + send);
        log.info("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        log.info(response.toString());

        String  answer = response.toString();
        //print result
//        System.out.println(response.toString());
        return  answer;

    }

}
