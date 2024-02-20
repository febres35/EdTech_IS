package cienciasucv.certicomp.Models;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CourseTest {

  private Course courseTest;
  private Map<String, Object> attributes;

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

  @BeforeEach
  public void setUp() {

    ArrayList<String> exams = new ArrayList<>();
    exams.add("Network fundamentals");
    exams.add("IP connectivity");

    attributes = new HashMap<>();
    attributes.put("name", "CCNA Routing and Switching");
    attributes.put("category", "Entry");
    attributes.put("teachers", "John Doe, Jane Smith");
    attributes.put("prerequisites", "None");
    attributes.put("description", 
    "The CCNA—which stands for Cisco Certified Network Associate—is an entry-level information technology (IT) certification issued by networking hardware company Cisco. The CCNA is designed to validate your knowledge on fundamental networking concepts often requested in networking roles in IT positions.");
    attributes.put("exams", exams);
    courseTest = new Course("NET101", attributes);
  }

  @Test
  public void testCourseConstructor() {
    assertNotNull(courseTest);
    assertEquals("NET101", courseTest.getID());
    assertEquals("CCNA Routing and Switching", courseTest.getName());
    assertEquals("Entry", courseTest.getCategory());
    assertEquals("John Doe, Jane Smith", courseTest.getTeachers());
    assertEquals("None", courseTest.getPrerequisites());
    assertEquals(
        "The CCNA—which stands for Cisco Certified Network Associate—is an entry-level information technology (IT) certification issued by networking hardware company Cisco. The CCNA is designed to validate your knowledge on fundamental networking concepts often requested in networking roles in IT positions.",
        courseTest.getDescription());
    assertEquals(2, courseTest.getExamsID().size());
    assertEquals("Network fundamentals", courseTest.getExamsID().get(0));
    assertEquals("IP connectivity", courseTest.getExamsID().get(1));
    assertEquals(attributes, courseTest.getAttributes());
  }

}