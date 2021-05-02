package englishdictionary;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

/**
 * The DictionaryTest class is used to test the mock English dictionary.
 * This tests if isEnglishWord works as expected
 */
@RunWith(Parameterized.class)
public class DictionaryTest {

    private String word;
    private boolean expectedResult;
    private Dictionary dictionary;

    @Before
    public void preTest() throws Exception {
        dictionary = new Dictionary();
    }

    @After
    public void postTest() throws Exception {
    }

    public DictionaryTest(String word, boolean expectedResult)
    {
        this.word = word;
        this.expectedResult = expectedResult;
    }

    /** englishWordsGenerator method is used
     * to generate a list of valid and invalid English words
     * returns the Collection of English words and expected result as parameters to isEnglishWord method
     */
    @Parameterized.Parameters
    public static Collection englishWordsGenerator() {
        return Arrays.asList(new Object[][] {
                //Sample input data to validate positive case
                { "work", true },
                //Sample input data to validate negative case
                { "ttfsd", false }
        });
    }

    /** isEnglishWordTest method is used to
     * test if isEnglishWord works as expected with passing multiple parameters
     */
    @Test
    public void isEnglishWordTest() {

        System.out.println("Calculated result for word : " + word + " is " + dictionary.isEnglishWord(word));
        System.out.println("Expected result for word : " + word + " is " + expectedResult);
        Assert.assertEquals("Expected results does not match",expectedResult, dictionary.isEnglishWord(word));

    }


}