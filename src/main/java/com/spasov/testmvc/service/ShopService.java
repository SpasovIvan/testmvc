package com.spasov.testmvc.service;

import com.spasov.testmvc.dao.ShopRepository;
import com.spasov.testmvc.entity.Shop;
import com.spasov.testmvc.exception.ShopNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
    public Shop findById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new ShopNotFoundException(id));
    }
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }
    public Shop update(Shop shop) {
        return shopRepository.save(shop);
    }
    public void delete(Long id) {
        shopRepository.deleteById(id);
    }
}
