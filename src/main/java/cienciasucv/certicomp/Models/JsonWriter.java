package cienciasucv.certicomp.Models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class JsonWriter {

    private static final Map< Class<?>, String> classFileMap = new HashMap<>();

    static {
        classFileMap.put(Domain.class, "cienciasucv\\certicomp\\src\\main\\resources\\data\\domains.json");
        classFileMap.put(Exam.class, "cienciasucv\\certicomp\\src\\main\\resources\\data\\exams.json");
        classFileMap.put(Question.class, "cienciasucv\\certicomp\\src\\main\\resources\\data\\questions.json");
        classFileMap.put(Answer.class, "cienciasucv\\certicomp\\src\\main\\resources\\data\\answers.json");
        classFileMap.put(User.class, "cienciasucv\\certicomp\\src\\main\\resources\\data\\users.json");
        classFileMap.put(Course.class, "cienciasucv\\certicomp\\src\\main\\resources\\data\\courses.json");
    }

    public static FileWriter getWriterForClass(Class<?> type) throws IOException {
        String filePath = classFileMap.get(type);
        if (filePath == null) {
            System.out.println("HERROR FILEWRITEr - NULL");
            throw new IllegalArgumentException("File path NOT found : " + type.getName());
        }
        return new FileWriter(filePath);
    }
}