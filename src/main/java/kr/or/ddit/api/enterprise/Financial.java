package kr.or.ddit.api.enterprise;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class Financial {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1130000/financeCompSttusList/financeCompSttusListApi"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("+2N1kkItMbq0tfVaDODQvkQe5/blxDsedAiLjmCbgZ40sDBJI8sotpCgTFDPzaARKba1K2ixJdZZK/YUV9IDwg==","UTF-8") + "=서비스키"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("presentnYear","UTF-8") + "=" + URLEncoder.encode("202105", "UTF-8")); /*기업집단 지정년월*/
        urlBuilder.append("&" + URLEncoder.encode("unityGrupCode","UTF-8") + "=" + URLEncoder.encode("K1000032", "UTF-8")); /*기업집단코드*/
        urlBuilder.append("&" + URLEncoder.encode("jurirno","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*법인등록번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
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
    }
}