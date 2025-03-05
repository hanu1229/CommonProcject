package common_project.controller;

import common_project.model.dto.UserDto;
import common_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    final private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /** 회원가입 */
    @PostMapping("/signup")
    public boolean _signup(@RequestBody() UserDto userDto) {
        boolean result = userService._signup(userDto);
        return result;
    }
    
    /** 로그인 */
    @PostMapping("/login")
    public boolean _login(@RequestBody() UserDto userDto) {
        boolean result = userService._login(userDto);
        return result;
    }

}
