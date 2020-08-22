package com.communa.stringutils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.*;

/**
 * @author vishal
 */

public class Comparor implements IStringOperation {

    /**
     * This method checks whether two Strings content are equals or not.
     * @suppress warning
     *
     * @param string1
     * @param string2
     *
     * The object to compare this {@code String} against
     *         The name of a supported {@linkplain java.lang.String
     *         charset}
     * @return the resultant boolean value
     */
    @Override
    public boolean stringEquals(String string1, String string2) throws IOException {

        if(string1.isEmpty() || string2.isEmpty())
            return false;

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readTree(string1).equals(mapper.readTree(string2));
    }
    /**
     * This method convert string into json node and json node converted
     * into map and passed for traversal
     * @suppress warning
     *
     * @param jsonNode1
     * @param jsonNode2
     *
     * The object to compare this {@code String} against
     *         The name of a supported {@linkplain com.fasterxml.jackson.databind
     *         charset}
     * @return the resultant contains all mismatched values List<Map<String, String>>
     *     that can be null if no mismatch found
     *
     * @throws IOException needs to handle in the caller
     */
    @Override
    public List<Map<String, String>> stringUnequals(JsonNode jsonNode1, JsonNode jsonNode2) {

        //mapReader method returns all mismatched elements
        List<Map<String, String>> misMatchList = mapReader((Map) jsonNode1, (Map) jsonNode2);

        return misMatchList;
    }

    /**
     * This method expects map as an argument and traverse of its all element
     * and compare with another map if found any mismatch it keeps it in container
     * and return to caller.
     *
     * @suppress warning
     *
     * @param map1
     * @param map2
     *
     * The object to compare this {@code String} against
     *         The name of a supported {@linkplain java.util
     *         charset}
     * @return the resultant contains all mismatched values List<Map<String, String>>
     *     it can return null if no mismatch found.
     *
     */
    private List<Map<String, String>> mapReader(Map map1, Map map2){

        List<Map<String, String>> misMatchList = new LinkedList<>();

        for (Object key : map1.keySet()) {

            if(map1.get(key) instanceof Map)
                mapReader((Map) map1.get(key), (Map)map2.get(key));

            if(!(map1.get(key).hashCode() == map2.get(key).hashCode())){

                Map<String, String> misMatch = new TreeMap<>();

                misMatch.put(Constant.OLDVALUE, map1.get(key).toString());
                misMatch.put(Constant.NEWVALUE, map2.get(key).toString());

                misMatchList.add(misMatch);
            }
        }
        return misMatchList;
    }

}
