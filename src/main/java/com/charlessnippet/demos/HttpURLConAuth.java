package com.charlessnippet.demos;

import java.io.*;
import java.net.*;
import java.util.Base64;

public class HttpURLConAuth {

    public static void main(String[] args) throws Exception {

        try {
            String webPage = "https://diahosting.axiell.com/AxiellWebAPIRonald/wwwopac.ashx?database=people.inf&search=Code=p1533";
            String name = "diahosting\\charles.shu";
            String password = "@ims2020!";
    
            String authString = name + ":" + password;
            System.out.println("auth string: " + authString);
            // byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("Base64 encoded auth string: " + authStringEnc);
    
            URL url = new URL(webPage);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
    
            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            String result = sb.toString();
    
            System.out.println("*** BEGIN ***");
            System.out.println(result);
            System.out.println("*** END ***");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}