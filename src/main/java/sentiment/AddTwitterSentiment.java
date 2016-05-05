//package sentiment;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import com.google.code.geocoder.Geocoder;
//import com.google.code.geocoder.GeocoderRequestBuilder;
//import com.google.code.geocoder.model.GeocodeResponse;
//import com.google.code.geocoder.model.GeocoderRequest;
//import org.apache.commons.io.FileUtils;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
///**
// * Created by shawnkyzer on 11/18/15.
// */
//public class AddTwitterSentiment {
//
//    public static void main(String[] args) {
//
//        JSONParser parser = new JSONParser();
//
//
//        try {
//
//            for(int i = 0; i <= 3000; i++) {
//                final Geocoder geocoder = new Geocoder();
//                GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Texas, US").setLanguage("en").getGeocoderRequest();
//                GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(geocoderResponse.getStatus() + geocoderResponse.getResults().toString());
//            }
//
//            System.exit(0);
//            Object obj = parser.parse(new FileReader(args[0]));
//            JSONObject jsonObject = (JSONObject) obj;
//
//            String text = (String) jsonObject.get("text");
//
//            VaderSentiment v = new VaderSentiment();
//            JSONObject sentiment = (JSONObject) parser.parse(v.getSentiment(text));
//
//            jsonObject.putIfAbsent("sentiment", sentiment.get("compound"));
//
//            writeJsonToFile(jsonObject.toJSONString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//    private static void writeJsonToFile(String jsonContent) {
//        try {
//
//            File file = new File("tweets_sentiment/" + System.currentTimeMillis() + ".JSON");
//            FileUtils.writeStringToFile(file, jsonContent);
//            System.out.println("Done");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
