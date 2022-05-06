package ConverterCurrency;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConversionService {

    private static List<String> UNITS = new ArrayList<>();
    private static Map<String, Rate> RATE_MAP = new HashMap<>();

    public static String[] getUnits() {
        return UNITS.toArray(String[]::new);
    }

    public static double getRate(String unit) {
        return RATE_MAP.get(unit).rate;
    }

    public static void initData() throws IOException {
        URL url = new URL(getUrl());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int response = connection.getResponseCode();
        if (response == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer data = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                data.append(inputLine);

            System.out.println(data.toString());
        }
    }

    private static String getUrl() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return "https://nrb.org.np/api/forex/v1/rates?page=1&per_page=10&from=" + date + "&to=" + date;
    }

    static class Rate {
        double rate;

        public Rate(double rate) {
            this.rate = rate;
        }
    }
}
