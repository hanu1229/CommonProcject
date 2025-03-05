package common_project.service;

import common_project.model.dto.UserDto;
import common_project.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final private UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    /** 회원가입 */
    public boolean _signup(UserDto userDto) {
        boolean result = userMapper._signup(userDto);
        return result;
    }

    /** 로그인 */
    public boolean _login(UserDto userDto) {
        List<UserDto> list = userMapper._login(userDto);
        System.out.println(list);
        boolean result = false;
        for(int index = 0; index < list.size(); index++) {
            UserDto temp = list.get(index);
            if(userDto.getId().equals(temp.getId()) && userDto.getPassword().equals(temp.getPassword())) {
                result = true;
                break;
            }
        }
        return result;
    }

}
