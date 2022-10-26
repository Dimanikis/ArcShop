package arc.ua.arcshop.configs;

import arc.ua.arcshop.dto.UserDTO;
import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.model.Role;
import arc.ua.arcshop.services.UserService;
import arc.ua.arcshop.services.GoodsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner demo(final GoodsService goodsService, final UserService userService) {
        return strings -> {
            goodsService.addGoods(GoodsDTO.of("test1", "testType", "mi", 1.00, 5));
            goodsService.addGoods(GoodsDTO.of("test2", "testType", "mi", 0.01, 5));
            goodsService.addGoods(GoodsDTO.of("test3", "testType", "xiaomi", 0.10, 5));
            goodsService.addGoods(GoodsDTO.of("test4", "testType", "xiaomi", 10.00, 5));
            goodsService.addGoods(GoodsDTO.of("test5", "testType", "xiaomi", 15.00, 5));
            goodsService.addGoods(GoodsDTO.of("test6", "testType", "apple", 100.00, 5));
            goodsService.addGoods(GoodsDTO.of("test7", "testType", "samsung", 110.00, 5));
            goodsService.addGoods(GoodsDTO.of("test8", "testType", "samsung", 150.00, 5));
            goodsService.addGoods(GoodsDTO.of("test9", "testType", "samsung", 10.10, 5));
            goodsService.addGoods(GoodsDTO.of("test10", "testType", "apple", 11.11, 5));
            goodsService.addGoods(GoodsDTO.of("test11", "testType", "apple", 1010.00, 5));
            userService.addUser(UserDTO.of("user1", passwordEncoder().encode("1234"), null,null,null, Role.ADMIN));
            userService.addUser(UserDTO.of("user", passwordEncoder().encode("1234"), "userName", null,null, Role.USER));
            userService.addUser(UserDTO.of("admin", passwordEncoder().encode("12345"), "adminName", null, null, Role.ADMIN));
        };
    }
}
