package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String makeJson(List<Map<String, Object>> difference) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(difference);
        return result.trim();
    }
}
