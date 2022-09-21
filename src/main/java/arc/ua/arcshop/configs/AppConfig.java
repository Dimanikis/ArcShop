package arc.ua.arcshop.configs;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.services.GoodsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner demo(final GoodsService goodsService) {
        return strings -> {
            goodsService.addGoods(new GoodsDTO("test1", "testType", "hyndai", 1.00, 5));
            goodsService.addGoods(new GoodsDTO("test2", "testType", "hyndai", 0.01, 5));
            goodsService.addGoods(new GoodsDTO("test3", "testType", "hyndai", 0.10, 5));
            goodsService.addGoods(new GoodsDTO("test4", "testType", "hyndai", 10.00, 5));
            goodsService.addGoods(new GoodsDTO("test5", "testType", "hyndai", 15.00, 5));
            goodsService.addGoods(new GoodsDTO("test6", "testType", "hyndai", 100.00, 5));
            goodsService.addGoods(new GoodsDTO("test7", "testType", "hyndai", 110.00, 5));
            goodsService.addGoods(new GoodsDTO("test8", "testType", "hyndai", 150.00, 5));
            goodsService.addGoods(new GoodsDTO("test9", "testType", "hyndai", 10.10, 5));
            goodsService.addGoods(new GoodsDTO("test10", "testType", "hyndai", 11.11, 5));
            goodsService.addGoods(new GoodsDTO("test11", "testType", "hyndai", 1010.00, 5));
        };
    }
}
