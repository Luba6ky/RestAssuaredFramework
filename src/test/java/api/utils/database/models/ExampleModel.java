package api.utils.database.models;

import api.utils.database.DBConnection;
import api.utils.logging.Log;
import lombok.Data;
import org.junit.jupiter.api.Assertions;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class ExampleModel extends DBConnection {

    private int id;
    private String name;
    private String email;
    private String phone;
    private List<String> roles;

    public void verifyUser(int userId, String expectedName, String expectedEmail, String expectedPhone, List<String> expectedRoles) throws Exception {

        ResultSet resultSet = executeQuery(
                "SELECT * FROM users WHERE id = " + userId);

        while (resultSet.next()) {
            this.id = resultSet.getInt("id");
            this.name = resultSet.getString("name");
            this.email = resultSet.getString("email");
            this.phone = resultSet.getString("phone");

            String[] colRoles = (String[]) resultSet.getArray("roles").getArray();
            List<String> rolesToList = Arrays.asList(colRoles);
            Collections.sort(rolesToList);
            Collections.sort(expectedRoles);

            Assertions.assertEquals(this.id, userId, "User ID does not match");
            Assertions.assertEquals(this.name, expectedName, "Name does not match");
            Assertions.assertEquals(this.email, expectedEmail, "Email does not match");
            Assertions.assertEquals(this.phone, expectedPhone, "Phone does not match");
            Assertions.assertEquals(rolesToList, expectedRoles, "Roles do not match");

            Log.info("User verified with ID: " + userId);
        }
    }
}
