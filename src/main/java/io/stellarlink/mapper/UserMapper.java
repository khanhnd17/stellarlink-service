package io.stellarlink.mapper;

import io.stellarlink.model.entity.User;
import io.stellarlink.model.dto.auth.RegisterRequest;
import io.stellarlink.model.dto.user.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserResponse toUserResponse(User request);
  User toUser(RegisterRequest registerRequest);
}
