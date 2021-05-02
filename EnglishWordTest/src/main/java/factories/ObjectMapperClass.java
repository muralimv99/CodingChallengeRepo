package factories;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The ObjectMapperClass class which is used to create and instance of ObjectMapper.
 */
public class ObjectMapperClass {

    static ObjectMapper objMap;

    /** getObjectMapper method is used to create and instance of ObjectMapper
     * used to read the JSON structure
     * returns the instance of ObjectMapper
     */
    public static ObjectMapper getObjectMapper()
    {
        if(objMap == null) {
            objMap = new ObjectMapper();
        }
        return objMap;
    }

}
