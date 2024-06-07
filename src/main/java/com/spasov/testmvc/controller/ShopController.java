package com.spasov.testmvc.controller;

import com.spasov.testmvc.entity.Shop;
import com.spasov.testmvc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping
    public String shops(Model model) {
        model.addAttribute("shops", shopService.findAll());
        return "shops";
    }

    @GetMapping("/{id}")
    public String shop(@PathVariable Long id, Model model) {
        model.addAttribute("shop", shopService.findById(id));
        return "shop";
    }

}
