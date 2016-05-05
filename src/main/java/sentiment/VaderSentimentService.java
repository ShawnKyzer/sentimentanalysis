package sentiment;

import spark.Spark;

import static spark.Spark.*;


/**
 * Created by shawnkyzer on 11/18/15.
 */
public class VaderSentimentService {

    public static void main(String[] args) {
        port(4567);

        Spark.options("/*", (request,response)->{

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if(accessControlRequestMethod != null){
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        Spark.before((request, response)->{
            response.header("Access-Control-Allow-Origin", "*");
        });
        get("/sentiment/:text", (req, res) -> {
            String text = req.params(":text");
            VaderSentiment v = new VaderSentiment();
            return v.getSentiment(text);
        });
    }
}
