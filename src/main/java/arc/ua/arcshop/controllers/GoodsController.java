package arc.ua.arcshop.controllers;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.dto.PageCountDTO;
import arc.ua.arcshop.services.GoodsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final int PAGE_SIZE = 5;

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
    public List<GoodsDTO> getGoods(@RequestParam(required = false, defaultValue = "0") int page,
                                   @RequestParam(required = false) String manufacturer,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String type,
                                   @RequestParam(required = false, defaultValue = "0") int min,
                                   @RequestParam(required = false, defaultValue = "2 147 483 647") int max){
        return goodsService.getGoods(PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, "id"), manufacturer, name, type, min, max);

    }

    @GetMapping("count")
    public PageCountDTO count() {
        return PageCountDTO.of(goodsService.count(), PAGE_SIZE);
    }



}
