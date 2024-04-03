package com.example.technologiesieciowelista1.Service;

import com.example.technologiesieciowelista1.LoginForm;
import com.example.technologiesieciowelista1.entity.User;
import com.example.technologiesieciowelista1.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Service
public class LoginService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.token.key}")
    private String key;

    // konstruktor z Autowired
    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public  String userLogin(LoginForm loginForm){
        User user = userRepository.findByUserName(loginForm.getLogin());
        //tutaj pobrać dane użytkownika z bazy do porównania
        if(passwordEncoder.matches(loginForm.getPassword()
                ,user.getPassword())){
            long timeMillis = System.currentTimeMillis();
            String token = Jwts.builder()
                    .issuedAt(new Date(timeMillis))
                    .expiration(new Date(timeMillis+30*60*1000))
                    .claim("id", user.getId())
                    .claim("role", user.getRole())
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();
            return token;
        } else {
            return null;    //lub wyjątek
        }
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }
}
// https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
// informacje o sesji użytkownika przy każdym zapytaniu token przy komunikacji z bazą danych
// dane o użytkowniku w token, w token nie ma żadnych danych wrażliwych - id, rola, bo są one zakodowane
// za pomocą klucza symetrycznego ten sam klucz do kodowania i odczytania