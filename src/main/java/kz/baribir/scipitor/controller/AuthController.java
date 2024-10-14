package kz.baribir.scipitor.controller;

import jakarta.validation.Valid;

import kz.baribir.scipitor.model.dto.LoginRequest;
import kz.baribir.scipitor.model.dto.UserDTO;
import kz.baribir.scipitor.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserDTO userDTO,
                                            BindingResult bindingResult) {
        try {
            boolean isSuccess = authService.register(userDTO);

            if (isSuccess) {
                return ResponseEntity.ok(userDTO);
            }

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<LoginRequest> login(@RequestBody LoginRequest loginRequest) {
        try {

            boolean isSuccess = authService.login(loginRequest);
            if (isSuccess) {
                return ResponseEntity.ok(loginRequest);
            }

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
