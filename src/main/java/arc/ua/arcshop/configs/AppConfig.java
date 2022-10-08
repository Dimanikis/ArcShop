package arc.ua.arcshop.configs;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.services.GoodsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner demo(final GoodsService goodsService) {
        return strings -> {
            goodsService.addGoods(new GoodsDTO("test1", "testType", "mi", 1.00, 5));
            goodsService.addGoods(new GoodsDTO("test2", "testType", "mi", 0.01, 5));
            goodsService.addGoods(new GoodsDTO("test3", "testType", "xiaomi", 0.10, 5));
            goodsService.addGoods(new GoodsDTO("test4", "testType", "xiaomi", 10.00, 5));
            goodsService.addGoods(new GoodsDTO("test5", "testType", "xiaomi", 15.00, 5));
            goodsService.addGoods(new GoodsDTO("test6", "testType", "apple", 100.00, 5));
            goodsService.addGoods(new GoodsDTO("test7", "testType", "samsung", 110.00, 5));
            goodsService.addGoods(new GoodsDTO("test8", "testType", "samsung", 150.00, 5));
            goodsService.addGoods(new GoodsDTO("test9", "testType", "samsung", 10.10, 5));
            goodsService.addGoods(new GoodsDTO("test10", "testType", "apple", 11.11, 5));
            goodsService.addGoods(new GoodsDTO("test11", "testType", "apple", 1010.00, 5));
        };
    }
}
