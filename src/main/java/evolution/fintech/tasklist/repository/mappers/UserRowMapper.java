package evolution.fintech.tasklist.repository.mappers;

import evolution.fintech.tasklist.domain.task.Task;
import evolution.fintech.tasklist.domain.user.Role;
import evolution.fintech.tasklist.domain.user.User;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.*;

public class UserRowMapper {
    /*
    * u.id              as user_id,
                   u.name            as user_name,
                   u.username        as user_username,
                   u.password        as user_password,
                   ur.role           as user_role,
                   t.id              as task_id,
                   t.title           as task_title,
                   t.description     as task_description,
                   t.expiration_date as task_expiration_date,
                   t.status          as task_status
    * */
    @SneakyThrows
    public static User mapRow(ResultSet resultSet) {
        Set<Role> roles = new HashSet<>();

        while (resultSet.next()) {
            String role = resultSet.getString("user_role_role");
            roles.add(Role.valueOf(role));
        }
        resultSet.beforeFirst();

        List<Task> tasks = TaskRowMapper.mapRows(resultSet);

        resultSet.beforeFirst();

        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setName(resultSet.getString("user_name"));
            user.setUsername(resultSet.getString("user_username"));
            user.setPassword(resultSet.getString("user_password"));
            user.setRoles(roles);
            user.setTasks(tasks);
            return user;
        }
        return null;
    }

    @SneakyThrows
    public static List<User> mapRows(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {

        }
        return Collections.emptyList();
    }
}
