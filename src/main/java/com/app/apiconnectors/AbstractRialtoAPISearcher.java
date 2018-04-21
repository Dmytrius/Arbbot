package main.java.com.app.apiconnectors;

import main.java.com.app.domain.AbstractPair;
import main.java.com.app.domain.BTC_USD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractRialtoAPISearcher {

    protected URL url;
    protected HttpURLConnection urlConn;
    protected InputStreamReader inStream = null;
    protected BufferedReader buff = null;
    protected String priceResponse;
    protected AbstractPair pair;

    public AbstractRialtoAPISearcher(String methodName) {
        StringBuffer response = new StringBuffer();
        try {
            this.url = new URL(methodName);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");
            inStream = new InputStreamReader(urlConn.getInputStream(), "UTF8");
            buff = new BufferedReader(inStream);

            String inputLine = "";
            while ((inputLine = buff.readLine()) != null) {
                response.append(inputLine);
            }

        } catch (MalformedURLException mfe){
            System.out.println("Please check the URL:" + mfe.toString() );
        } catch(IOException e){
            System.out.println("Can’t read from the Internet: " + e.toString() );
        } finally{
            if (inStream != null){
                try{
                    inStream.close();
                    buff.close();
                } catch(IOException e1){
                    System.out.println("Can’t close the streams: " + e1.getMessage());
                }
            }
        }
        priceResponse = response.toString();
    }

    public String getPriceResponce() {
        return priceResponse;
    }

    public abstract AbstractPair getBTC_USDPair();
}
