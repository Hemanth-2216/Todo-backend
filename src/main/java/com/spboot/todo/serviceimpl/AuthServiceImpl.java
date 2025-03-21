package com.spboot.todo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spboot.todo.Dto.UserDto;
import com.spboot.todo.Dto.LoginDto;
import com.spboot.todo.entity.User;
import com.spboot.todo.exception.TodoApiException;
import com.spboot.todo.repository.UserRepository;
import com.spboot.todo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // ✅ This line added for encryption

    @Override
    public String register(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new TodoApiException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new TodoApiException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        User user = new User();
        user.setFullname(userDto.getFullname());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));  // ✅ Encrypt password
        user.setEmail(userDto.getEmail());

        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String login(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new TodoApiException(HttpStatus.UNAUTHORIZED, "Invalid username or password!"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {  // ✅ Match with encoded password
            throw new TodoApiException(HttpStatus.UNAUTHORIZED, "Invalid username or password!");
        }

        // Returning userId and username for frontend storage
        return user.getId() + "," + user.getUsername();
    }
}
