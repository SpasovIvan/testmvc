package com.spasov.testmvc;

import com.spasov.testmvc.entity.Category;
import com.spasov.testmvc.entity.Shop;
import com.spasov.testmvc.service.CategoryService;
import com.spasov.testmvc.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ShopService shopService, CategoryService categoryService) {
        return args -> {
            Category category = new Category();
            category.setName("Sport");
            categoryService.save(category);
            Category category2 = new Category();
            category2.setName("Products");
            categoryService.save(category2);

            Shop shop = new Shop();
            shop.setName("Shop 1");
            shop.setPhone("123456789");
            shop.setAddress("Address 1");
            shop.setEmail("1email@mail.com");
            shop.setDescription("Description 1");
            shop.setLink("https://www.google.com");
            shop.setCategory(category);
            shopService.save(shop);
            LOG.info("Preloading " + shop);

            Shop shop2 = new Shop();
            shop2.setName("Shop 2");
            shop2.setPhone("987654321");
            shop2.setAddress("Address 2");
            shop2.setEmail("2email@mail.com");
            shop2.setDescription("Description 2");
            shop2.setLink("https://www.google.com");
            shop2.setCategory(category2);
            shopService.save(shop2);
            LOG.info("Preloading " + shop2);

            Shop shop3 = new Shop();
            shop3.setName("Shop 3");
            shop3.setPhone("987654321");
            shop3.setAddress("Address 3");
            shop3.setEmail("3email@mail.com");
            shop3.setDescription("Description 3");
            shop3.setLink("https://www.google.com");
            shop3.setCategory(category);
            shopService.save(shop3);
            LOG.info("Preloading " + shop3);

            category.setShops(List.of(shop, shop3));
            categoryService.save(category);
            LOG.info("Preloading " + category);
            category2.setShops(List.of(shop2));
            categoryService.save(category2);
        };
    }
}
