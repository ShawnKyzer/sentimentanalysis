package sentiment;

/**
 * Created by shawnkyzer on 11/18/15.
 */



import java.io.*;

public class VaderSentiment{
    public static void main(String a[]){
        VaderSentiment v = new VaderSentiment();
        System.out.println(v.getSentiment("I hate cats, but I really love elephants"));
    }

    public String getSentiment(String text){
        Process p = null;
        String sentiment = null;
        try{
            String path= "/root/sentimentService/resources";
            ProcessBuilder pb = new ProcessBuilder("python2.7", path+"/vaderSentiment.py", "\""+text+"\"");
            p = pb.start();
            p.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            sentiment = in.readLine().toString();
        }catch(Exception e){
            System.out.println("Error" + getStackTrace(e));
        } finally{
            p.destroy();
        }
        return sentiment;
    }

    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

}

