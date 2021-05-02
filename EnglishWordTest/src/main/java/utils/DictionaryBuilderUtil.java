package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import factories.ObjectMapperClass;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

/**
 * The DictionaryBuilderUtil class is used to build a map
 * of all valid English words from the JSON
 */
public class DictionaryBuilderUtil {

    private HashMap<String, Integer> wordMap = null;

    /** getEnglishWordList method to build a map
     * of all valid English words from the JSON data file
     * returns HaspMap of all English words listed in the file
     */
    public HashMap<String,Integer> getEnglishWordList() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL is = classloader.getResource("data/words_dictionary.json");
            ObjectMapper objMapper = ObjectMapperClass.getObjectMapper();
            wordMap = objMapper.readValue(new File(is.getPath()), HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordMap;
    }

}
