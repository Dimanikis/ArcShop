package arc.ua.arcshop.controllers;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.services.GoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    public final GoodsService goodsService;


    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("addGoods")
    public ResponseEntity<Void> addGoods(@RequestBody GoodsDTO goodsDTO){
        goodsService.addGoods(goodsDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getGoods")
    public List<GoodsDTO> getGoods(){
        return goodsService.getGoods();

    }



}
