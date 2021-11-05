package com.chandalalatinashe.user.service;


import com.chandalalatinashe.user.entity.User;
import com.chandalalatinashe.user.repository.UserRepository;
import com.chandalalatinashe.user.value.objects.Department;
import com.chandalalatinashe.user.value.objects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        log.info("Inside findUserById method of UserService");
        return userRepository.getById(id);

    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.getById(userId);

        //Get department from the department micro-service
        Department department = restTemplate.getForObject(
                        "http://localhost:8080/departments/"+user.getDeptId()
                            , Department.class);


        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
