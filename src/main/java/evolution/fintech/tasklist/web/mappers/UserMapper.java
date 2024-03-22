package evolution.fintech.tasklist.web.mappers;

import evolution.fintech.tasklist.domain.user.User;
import evolution.fintech.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
