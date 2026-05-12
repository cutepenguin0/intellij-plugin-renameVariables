package org.plugin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameTypeSuggestions {
    public static final Map<String, List<String>> ABBREVIATION_SUGGESTIONS = new HashMap<>();
    public static final Map<String, List<String>> TYPE_SUGGESTIONS = new HashMap<>();
    static {
        ABBREVIATION_SUGGESTIONS.put("tmp", List.of("temp", "temporary"));
        ABBREVIATION_SUGGESTIONS.put("x", List.of("index", "value"));
        ABBREVIATION_SUGGESTIONS.put("str", List.of("text", "string"));
        ABBREVIATION_SUGGESTIONS.put("res", List.of("result", "response"));
        ABBREVIATION_SUGGESTIONS.put("i", List.of("index", "iterator"));
        ABBREVIATION_SUGGESTIONS.put("j", List.of("index", "iterator"));
        ABBREVIATION_SUGGESTIONS.put("m", List.of("max", "min", "member"));
        ABBREVIATION_SUGGESTIONS.put("n", List.of("number", "count", "size"));
        ABBREVIATION_SUGGESTIONS.put("arr", List.of("array", "list", "collection"));
        ABBREVIATION_SUGGESTIONS.put("obj", List.of("object", "instance", "entity"));
        ABBREVIATION_SUGGESTIONS.put("val", List.of("value", "result", "output"));
        ABBREVIATION_SUGGESTIONS.put("data", List.of("dataset", "information", "records"));
        ABBREVIATION_SUGGESTIONS.put("num", List.of("number", "count", "quantity"));
        ABBREVIATION_SUGGESTIONS.put("flag", List.of("isValid", "hasValue", "isActive"));
        ABBREVIATION_SUGGESTIONS.put("msg", List.of("message", "text", "content"));
        ABBREVIATION_SUGGESTIONS.put("cfg", List.of("config", "configuration", "settings"));
        ABBREVIATION_SUGGESTIONS.put("err", List.of("error", "exception", "failure"));
        ABBREVIATION_SUGGESTIONS.put("conn", List.of("connection", "link"));
        ABBREVIATION_SUGGESTIONS.put("db", List.of("database", "dataSource"));
        ABBREVIATION_SUGGESTIONS.put("len", List.of("length", "size", "count"));
        ABBREVIATION_SUGGESTIONS.put("idx", List.of("index", "position", "offset"));
        ABBREVIATION_SUGGESTIONS.put("cnt", List.of("count", "counter"));
        ABBREVIATION_SUGGESTIONS.put("pos", List.of("position", "index", "offset"));
    }

    static {

        TYPE_SUGGESTIONS.put("int", List.of("count", "index", "size", "number", "length", "offset"));
        TYPE_SUGGESTIONS.put("String", List.of("name", "value", "text", "description", "label", "message"));
        TYPE_SUGGESTIONS.put("List", List.of("items", "list", "elements", "collection", "arrayList", "sequence"));
        TYPE_SUGGESTIONS.put("boolean", List.of("flag", "isValid", "enabled", "success", "active", "exists"));
        TYPE_SUGGESTIONS.put("double", List.of("rate", "percentage", "amount", "value", "ratio", "score"));
        TYPE_SUGGESTIONS.put("float", List.of("rate", "percentage", "amount", "value", "ratio", "score"));
        TYPE_SUGGESTIONS.put("long", List.of("timestamp", "id", "count", "size", "duration", "identifier"));
        TYPE_SUGGESTIONS.put("Map", List.of("map", "dictionary", "lookup", "associations", "keyValuePairs", "registry"));
        TYPE_SUGGESTIONS.put("Set", List.of("set", "uniqueItems", "collection", "keys", "distinctValues", "group"));
        TYPE_SUGGESTIONS.put("Object", List.of("object", "instance", "entity", "item", "component", "reference"));
        TYPE_SUGGESTIONS.put("char", List.of("character", "letter", "symbol", "code", "delimiter", "charValue"));
        TYPE_SUGGESTIONS.put("byte", List.of("data", "byteValue", "buffer", "content", "binaryData", "payload"));
        TYPE_SUGGESTIONS.put("short", List.of("value", "number", "count", "index", "shortValue", "code"));

        TYPE_SUGGESTIONS.put("Integer", List.of("count", "index", "size", "number", "wrapper", "nullableCount"));
        TYPE_SUGGESTIONS.put("Boolean", List.of("flag", "isValid", "enabled", "success", "nullableFlag", "condition"));
        TYPE_SUGGESTIONS.put("Double", List.of("rate", "percentage", "amount", "value", "nullableRate", "measurement"));
        TYPE_SUGGESTIONS.put("Long", List.of("timestamp", "id", "count", "size", "nullableId", "longValue"));

        TYPE_SUGGESTIONS.put("Optional", List.of("optional", "maybe", "nullableValue", "potential", "wrapper", "container"));
        TYPE_SUGGESTIONS.put("Stream", List.of("stream", "sequence", "flow", "pipeline", "dataStream", "iterator"));
        TYPE_SUGGESTIONS.put("Array", List.of("array", "elements", "fixedList", "dataArray", "collection", "values"));
        TYPE_SUGGESTIONS.put("Collection", List.of("collection", "items", "group", "aggregate", "setOfItems", "container"));
        TYPE_SUGGESTIONS.put("Queue", List.of("queue", "fifo", "waitingList", "buffer", "sequence", "line"));
        TYPE_SUGGESTIONS.put("Deque", List.of("deque", "doubleEndedQueue", "stackQueue", "buffer", "sequence", "list"));
        TYPE_SUGGESTIONS.put("Iterator", List.of("iterator", "cursor", "traverser", "pointer", "enumerator", "walker"));
    }
}
