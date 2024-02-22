package cienciasucv.certicomp.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserTest {

    private User userSearch;
    private String jsonFilePath;

    @BeforeEach
    void setUp(@TempDir Path tempDir) throws IOException {
        userSearch = new User();
        jsonFilePath = tempDir.resolve("users.json").toString();
        String jsonContent = "{\"123\":{\"name\":\"John\",\"lastname\":\"Doe\",\"role\":\"admin\"},\"456\":{\"name\":\"Jane\",\"lastname\":\"Doe\",\"role\":\"user\"}}";
        Files.writeString(tempDir.resolve("users.json"), jsonContent);
    }

    @Test
    void searchUserById_success() throws IOException {
        Map<String, Object> expectedUser = new HashMap<>();
        expectedUser.put("name", "John");
        expectedUser.put("lastname", "Doe");
        expectedUser.put("nationalId", "123");
        expectedUser.put("role", "admin");

        Map<String, Object> actualUser = userSearch.searchUserById(jsonFilePath, "123");

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void searchUserById_notFound() throws IOException {
        Map<String, Object> actualUser = userSearch.searchUserById(jsonFilePath, "789");

        assertNull(actualUser);
    }

    @Test
    void searchUserById_fileNotFound() throws IOException {
        Map<String, Object> actualUser = userSearch.searchUserById("non_existent_file.json", "123");

        assertNull(actualUser);
    }
}
