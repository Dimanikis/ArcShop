package arc.ua.arcshop.controllers;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.dto.GoodsShortDTO;
import arc.ua.arcshop.dto.PageCountDTO;
import arc.ua.arcshop.services.GoodsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final int PAGE_SIZE = 8;

    public final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("addGoods")
    public ResponseEntity<String> addGoods(@RequestBody GoodsDTO goodsDTO){
        if(goodsDTO.getPrice() < 0){
            return new ResponseEntity<>("""
                            {"status": "price must be positive"}""",HttpStatus.OK);
        }

        if(goodsDTO.getDiscount() < 0 || goodsDTO.getDiscount() > 100){
            return new ResponseEntity<>("""
                            {"status": "Discount must be positive or less than 100"}""",HttpStatus.OK);
        }

        if ( ! goodsService.addGoods(goodsDTO)) {
            return new ResponseEntity<>("""
                            {"status": "goods already exist"}""",HttpStatus.OK);
        }

        return new ResponseEntity<>("""
                            {"status": "created"}""",HttpStatus.OK);
    }

    @GetMapping("getGoods")
    public List<GoodsShortDTO> getGoods(@RequestParam(required = false, defaultValue = "0") int page,
                                            @RequestParam(required = false) String name,
                                            @RequestParam(required = false) String type,
                                            @RequestParam(required = false, defaultValue = "0") int min,
                                            @RequestParam(required = false, defaultValue = "2 147 483 647") int max){
        return goodsService.getGoods(PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, "id"), name, type, min, max);
    }

    @GetMapping("getGood")
    public GoodsDTO getGood(@RequestParam long id){
        return goodsService.getGood(id);
    }

    @PostMapping("updateGoods")
    public ResponseEntity<String> updateGoods(@RequestBody GoodsDTO goodsDTO){
        if(goodsDTO.getPrice() < 0){
            return new ResponseEntity<>("""
                            {"status": "price must be positive"}""",HttpStatus.OK);
        }

        if(goodsDTO.getDiscount() < 0 || goodsDTO.getDiscount() > 100){
            return new ResponseEntity<>("""
                            {"status": "Discount must be positive or less than 100"}""",HttpStatus.OK);
        }

        if ( ! goodsService.updateGoods(goodsDTO)) {
            return new ResponseEntity<>("""
                            {"status": "goods not found"}""",HttpStatus.OK);
        }

        return new ResponseEntity<>("""
                            {"status": "updated"}""",HttpStatus.OK);
    }

    @PostMapping("deleteGoods")/////////////////////////////////
    public ResponseEntity<String> deleteGoods(@RequestParam List<Long> ids){
        goodsService.deleteGoods(ids);
        return new ResponseEntity<>("""
                            {"status": "deleted"}""",HttpStatus.OK);
    }

    @GetMapping("count")
    public PageCountDTO count() {
        return PageCountDTO.of(goodsService.count(), PAGE_SIZE);
    }


}
