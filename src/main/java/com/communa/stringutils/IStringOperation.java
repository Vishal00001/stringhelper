package com.communa.stringutils;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public interface IStringOperation {

   /**
    *  This checks the content of the string and returns true if equals
    * @param string1
    * @param string2
    * @return boolean
    * @throws Exception
    */
   boolean stringEquals(String string1, String string2) throws Exception;

   /**
    * This checks the unequality of the strings using recursion methodology
    * and returns the list of unmatched string.
    * @param jsonNode1
    * @param jsonNode2
    * @return List<Map<String, String>>
    */
   List<Map<String, String>> stringUnequals(JsonNode jsonNode1, JsonNode jsonNode2);
}
