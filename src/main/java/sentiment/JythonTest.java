package sentiment;

/**
 * Created by shawnkyzer on 12/3/15.
 */
public class JythonTest {


        public static void main(String[] args) {

            // Obtain an instance of the object factory
            JythonObjectFactory factory = JythonObjectFactory.getInstance();

            // Call the createObject() method on the object factory by
            // passing the Java interface and the name of the Jython module
            // in String format. The returning object is casted to the the same
            // type as the Java interface and stored into a variable.
            VaderSentimentType sentimentType = (VaderSentimentType) factory.createObject(
                    VaderSentimentType.class, "vaderSentiment");
            // Populate the object with values using the setter methods
            System.out.println(sentimentType.sentiment("test"));

    }

}
