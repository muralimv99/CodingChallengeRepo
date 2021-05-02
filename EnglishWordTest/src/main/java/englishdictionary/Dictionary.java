package englishdictionary;

import java.util.HashMap;
import utils.DictionaryBuilderUtil;

/**
 * The Dictionary class which is used to mock English dictionary.
 * This checks if an English word is valid
 */
public class Dictionary {

    HashMap<String,Integer> wordMap = null;

    public Dictionary()
    {
        DictionaryBuilderUtil dictBuild = new DictionaryBuilderUtil();
        wordMap = dictBuild.getEnglishWordList();
    }

    /** isEnglishWord method to verify the validity of an English word
     * returns true if the passed word is valid if not false
     * @param word String
     */
    public boolean isEnglishWord(String word)
    {
        boolean isFound = false;
        if (wordMap.containsKey(word)) {
            isFound =true;
        }
        return isFound;
    }
}
