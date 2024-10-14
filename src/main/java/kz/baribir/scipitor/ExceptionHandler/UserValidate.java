package kz.baribir.scipitor.ExceptionHandler;

import kz.baribir.scipitor.model.entity.User;
import kz.baribir.scipitor.repository.postgre.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidate implements Validator {
    UserRepository userRepository;
    @Autowired
    public UserValidate(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        User tempUser = userRepository.findByUsername(user.getUsername());
        if(tempUser != null && tempUser.getEmail().equals(user.getEmail())){
            errors.rejectValue("username", "", "There is already an user with such username or email");
        }
    }
}
