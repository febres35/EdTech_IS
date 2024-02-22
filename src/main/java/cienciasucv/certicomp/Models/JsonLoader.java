package cienciasucv.certicomp.Models;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonLoader {

    private static final Map< Class<?>, String> classFileMap = new HashMap<>();

    static {
        classFileMap.put(Domain.class, "/data/domains.json");
        classFileMap.put(Exam.class, "/data/exams.json");
        classFileMap.put(Question.class, "/data/questions.json");
        classFileMap.put(Answer.class, "/data/answers.json");
        classFileMap.put(User.class, "/data/users.json");
        classFileMap.put(Course.class, "/data/courses.json");
    }

    public static <T> Map<String, T> loadFromFile(Class<T> type) throws IOException {
        String filePath = classFileMap.get(type);
        if (filePath == null) {
            System.out.println("null");
            throw new IllegalArgumentException("File path NOT found : " + type.getName());
        }
    
        Gson gson = new Gson();
        InputStream inputStream = type.getResourceAsStream(filePath);
        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        java.lang.reflect.Type mapType = TypeToken.getParameterized(Map.class, String.class, type).getType();
        Map<String, T> classMap = gson.fromJson(reader, mapType);
        reader.close();
        return classMap;
    }
}
    