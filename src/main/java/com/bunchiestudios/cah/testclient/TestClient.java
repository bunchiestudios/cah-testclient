/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bunchiestudios.cah.testclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import  org.json.*;
/**
 *
 * @author franspaco
 */
public class TestClient {
    public static void main(String[] args) throws MalformedURLException, IOException{
        JSONObject obj = new JSONObject();
        obj.put("id", "????");
        
        String out = obj.toString();
        
        System.out.println("TO SEND:\n" + out);
        
        String type = "application/x-www-form-urlencoded";
        
        URL url = new URL("http://127.0.0.1:4242/users");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty( "Content-Type", type );
        con.setRequestProperty( "Content-Length", String.valueOf(out.length()));
        OutputStream os = con.getOutputStream();
        os.write(out.getBytes());
        os.close();
        
        System.out.println("Response:");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String decodedString;
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();
    }
}
