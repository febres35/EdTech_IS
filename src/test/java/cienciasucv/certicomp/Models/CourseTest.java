package cienciasucv.certicomp.Models;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

  Course courseTest = new Course();

    @Test
    @DisplayName("Test generating course ID")
    public void testGenerateCourseId() throws IOException {
        // Set up the test JSON file
        Path testFilePath = Paths.get("src/test/resources/data/courses.json");
        String testJson = "{\"C001\": \"\", \"C005\": \"\", \"C011\": \"\"}";
        Files.write(testFilePath, testJson.getBytes());

        // Call the generateCourseId method
        String courseId = courseTest.generateCourseId("src/test/resources/data/courses.json");

        // Assert the result
        assertEquals("C012", courseId);

        // Clean up the test JSON file
        Files.delete(testFilePath);
    }

}