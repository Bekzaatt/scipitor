package kz.baribir.scipitor.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank
    @Min(value = 1, message = "Your username should be greater than 1 letter")
    private String username;
    @NotBlank
    @Size(min=8, message = "Password has to be more than 8")
    private String password;
    @Email
    @NotBlank
    private String email;
}
