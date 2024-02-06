package cienciasucv.Controllers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TakeExamController{

  public List<String> extractDataFromFile(File Exam) throws IOException {
    List<String> dataList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader ("TakeExam/presentarexamen/src/main/resources/data/preguntas.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
          dataList.add(line);
        }
    }
    for (String str : dataList) {
      System.out.println(str);
    }
    return dataList;
  }

  public int getExamDuration(){

    int durationSec = 0;
    int durationExam = 0;

    durationSec = 3600*durationExam;

    return durationSec;
  }

// public List<String> extractDataFromFiles(List<File> files) throws IOException {
//     List<String> dataList = new ArrayList<>();
//     for (File file : files) {
//         dataList.addAll(extractDataFromFile(file));
//     }
//     return dataList;
// }

}