package kr.or.ddit.api.enterprise;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class Outline {
    public static void main(String[] args) throws IOException {
    	StringBuilder urlBuilder = new StringBuilder("http://api.odcloud.kr/api/nts-businessman/v1/validate"); /*URL*/
        urlBuilder.append("?serviceKey=" + URLEncoder.encode("%2B2N1kkItMbq0tfVaDODQvkQe5%2FblxDsedAiLjmCbgZ40sDBJI8sotpCgTFDPzaARKba1K2ixJdZZK%2FYUV9IDwg%3D%3D", "UTF-8")); /*Service Key*/
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        System.out.println("Full Request Test 22222222");
    }
}
