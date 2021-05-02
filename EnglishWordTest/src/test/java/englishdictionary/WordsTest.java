package englishdictionary;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import utils.PermutationIterable;
import utils.PowerSetIterable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The WordsTest class is used to test the mock English dictionary.
 * This tests if the generated words of a String are valid by comparing against the expected results
 */
@RunWith(Parameterized.class)
public class WordsTest {

    private String word;
    private ArrayList<String> englishWordList;

    /** getEnglishWords method is used
     * to generate a list of String and expected valid English sub words that can be made
     * returns a Collection of String and expected English word list as parameters to checkEnglishWords method
     */
    @Parameterized.Parameters
    public static Collection getEnglishWords() {
        return Arrays.asList(new Object[][] {
                //Sample data with no repetitions to check right values are retrieved
                { "working", new ArrayList<String>(Arrays.asList("g","gi","gin","gink","gio","girn","giro","giron","gn",
                                                                 "gnow","go","goi","gon","gonk","gor","gorki","gowk",
                                                                 "gown","gr","grin","gro","groin","grow","grown","i",
                                                                 "ign","ik","ikon","in","ing","ingrow","ink","ino","inorg",
                                                                 "inro","inwork","io","ion","ir","irk","irok","iron","iw",
                                                                 "k","kg","kgr","ki","kin","king","kingrow","kino","kirn",
                                                                 "kn","know","ko","koi","kon","kong","kor","kori","korin",
                                                                 "kr","kw","n","ng","ni","nig","niog","no","nog","noir",
                                                                 "nor","nori","nork","now","nr","o","og","oik","oink","ok",
                                                                 "oki","on","oni","or","org","orig","ow","owing","owk",
                                                                 "own","r","rg","rig","rik","rin","ring","rink","rio",
                                                                 "rn","ro","rog","roi","roin","rok","ron","rong","row",
                                                                 "rowing","w","wg","wi","wig","win","wing","wink","wino",
                                                                 "wir","wk","wo","wog","wok","won","wong","wonk","work",
                                                                 "working","worn","wr","wrig","wring","wro","wrong")) },
                //Sample data with repeated letters to check unique values are retrieved
                { "aaabbddggee", new ArrayList<String>(Arrays.asList("a","aa","aaa","ab","aba","abada","abb","abba","abbe",
                                                                    "abd","abe","abed","abede","abedge","abegge","ad",
                                                                    "ada","adad","adage","add","adda","ade","adead","ae",
                                                                    "ag","aga","agad","agada","agade","agag","agba","age",
                                                                    "aged","agee","b","ba","baa","baaed","bab","baba",
                                                                    "babe","bad","badaga","bade","badge","badged","bae",
                                                                    "bag","baga","bagdad","bagge","bagged","bb","bd","bde",
                                                                    "be","bea","bead","beaded","bebed","bed","bedad","bede",
                                                                    "bedead","bee","beg","begad","begged","bg","d","da",
                                                                    "dab","dabb","dabba","dabbed","dad","dada","dade","dae",
                                                                    "dag","dagaba","dagga","dagged","db","dd","de","dea",
                                                                    "dead","deb","debadge","debag","debagged","debe","deda",
                                                                    "dee","deed","deg","degage","degged","dg","dgag","e",
                                                                    "ea","ead","ebb","ebbed","ed","edda","edea","edge",
                                                                    "edged","ee","eg","egad","egba","egg","egged","g","ga",
                                                                    "gab","gabbed","gabe","gabgab","gad","gadaba","gadaea",
                                                                    "gadbee","gade","gadge","gae","gaea","gaed","gag","gaga",
                                                                    "gage","gaged","gagee","gd","ge","geb","ged","gedd",
                                                                    "gee","geed")) },
                //Sample data with letters and numbers to check numbers are skipped
                { "w1o3r6k", new ArrayList<String>(Arrays.asList("k","ko","kor","kr","kw","o","ok","or","ow","owk","r","ro",
                                                                 "rok","row","w","wk","wo","wok","work","wr","wro"))}
        });
    }

    public WordsTest(String word, ArrayList<String> englishWordList) {
        this.word = word;
        this.englishWordList = englishWordList;
    }

    /** checkEnglishWords method is used to
     * test if the Dictionary Class works as expected with multiple parameters
     */
    @Test
    public void checkEnglishWords() {

        Dictionary dict = new Dictionary();
        ArrayList<String> wordsList = new ArrayList<>();
        List<String> fullSet = new ArrayList<>();
        List<Character> list = word.toLowerCase().chars().mapToObj(e->(char)e).collect(Collectors.toList());

        PowerSetIterable<Character> powerSet =
                new PowerSetIterable<>(list);
        for (List<Character> subset : powerSet)
        {
            String strSet = subset.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            PermutationIterable<Character> permutations =
                    new PermutationIterable<>(subset);
            if (!fullSet.contains(strSet))
            {
                for (List<Character> permutation : permutations) {
                    if (!permutation.isEmpty()) {
                        String engWord = permutation.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());
                        if (dict.isEnglishWord(engWord)) {
                            if (!wordsList.contains(engWord)) {
                                wordsList.add(engWord);
                            }
                        }
                    }
                }
                fullSet.add(strSet);
            }
        }
        Collections.sort(wordsList);
        Collections.sort(englishWordList);
        System.out.println("Calculated List : "+wordsList);
        System.out.println("Expected List : "+englishWordList);
        Assert.assertEquals("Expected results do not match",wordsList,englishWordList);
    }
}
