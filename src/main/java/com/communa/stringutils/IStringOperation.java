package com.communa.stringutils;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public interface IStringOperation {

   boolean stringEquals(String string1, String string2) throws Exception;

   List<Map<String, String>> stringUnequals(JsonNode jsonNode1, JsonNode jsonNode2);
}
