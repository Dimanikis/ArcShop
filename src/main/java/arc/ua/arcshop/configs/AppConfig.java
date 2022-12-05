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
            String description = """
                    Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra. Version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio.
                    Lorem ipsum dolor sit amet.
                    Tempore reiciendis reprehenderit cum molestiae!
                    Esse ipsum voluptates culpa voluptas!
                    Velit expedita voluptatem repudiandae veniam!
                    Fugit in voluptatem aperiam iure?
                    Incidunt commodi minus ea! Ullam?
                    Sed accusantium facere doloribus consequatur.
                    Doloribus aut excepturi cum sapiente.
                    Laborum tempora voluptate unde perferendis.
                    Quasi ipsam quo minus delectus!
                    """;

            String aDescription = """
                    Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Nulla vitae elit libero, a pharetra augue. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec sed odio dui. Donec sed odio dui.
                    Lorem ipsum dolor sit amet.
                    Veniam voluptatem sequi consequuntur in.
                    Ut nihil ad nobis tempora?
                    Sapiente, adipisci. Saepe, repudiandae molestiae.
                    Eos ut cumque harum minus!
                    """;

            String review = """
            Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo. Nullam ac urna eu felis dapibus condimentum sit amet a augue
            """;

            goodsService.addGoods(GoodsDTO.of("Ice Cream Covered With Chocolate & Nuts", "Cakes", 10.00, 50, description, aDescription, review, 5));
            goodsService.addGoods(GoodsDTO.of("Organic Mushroom", "Cakes", 100.00, 50, description, aDescription, review, 50));
            goodsService.addGoods(GoodsDTO.of("Green Peppercorn", "Vegetables", 1.00, 0, description, aDescription, review, 8));
            goodsService.addGoods(GoodsDTO.of("Vegetable Smoothie", "Smoothie", 50.00, 18, description, aDescription, review, 10));
            goodsService.addGoods(GoodsDTO.of("Banana Blossoms", "Vegetables", 60.00, 50, description, aDescription, review, 40));
            goodsService.addGoods(GoodsDTO.of("Purple Cabbage", "Vegetables", 60.00, 50, description, aDescription, review, 50));
            goodsService.addGoods(GoodsDTO.of("Pomegranate Juice", "Vegetables", 60.00, 50, description, aDescription, review, 50));
            goodsService.addGoods(GoodsDTO.of("Green Detox Drink", "Vegetables", 30.00, 0, description, aDescription, review, 5));
            goodsService.addGoods(GoodsDTO.of("Fresh Tomatoes", "Vegetables", 200.00, 50, description, aDescription, review, 50));
            goodsService.addGoods(GoodsDTO.of("Cabbage", "Vegetables", 100.00, 0, description, aDescription, review, 50));
            goodsService.addGoods(GoodsDTO.of("Detox Fresh Mango Smoothie", "Smoothie", 30.00, 0, description, aDescription, review, 5));
            goodsService.addGoods(GoodsDTO.of("Fresh Detox Blueberries", "Smoothie", 30.00, 0, description, aDescription, review, 5));
            goodsService.addGoods(GoodsDTO.of("Colorful Popsicles Isolated", "Smoothie", 60.00, 50, description, aDescription, review, 5));
            goodsService.addGoods(GoodsDTO.of("Cappuccino Ice Cream", "Smoothie", 60.00, 50, description, aDescription, review, 50));
            goodsService.addGoods(GoodsDTO.of("Detox Fresh Mango Juice", "Juice", 30.00, 0, description, aDescription, review, 5));
            goodsService.addGoods(GoodsDTO.of("Simple Kiwi Juice", "Juice", 30.00, 0, description, aDescription, review, 5));
            goodsService.addGoods(GoodsDTO.of("Apple", "Fruits", 200.00, 50, description, aDescription, review, 50));

            userService.addUser(UserDTO.of("user", passwordEncoder().encode("1234"), "userName", null,null, Role.USER));
            userService.addUser(UserDTO.of("admin", passwordEncoder().encode("12345"), "adminName", null, null, Role.ADMIN));
        };
    }
}
