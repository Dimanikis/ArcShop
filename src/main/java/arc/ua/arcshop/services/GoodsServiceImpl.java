package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.model.Goods;
import arc.ua.arcshop.model.QGoods;
import arc.ua.arcshop.repository.GoodsRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    private final GoodsRepository goodsRepository;


    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Transactional
    @Override
    public void addGoods(GoodsDTO goodsDTO){

        if(goodsDTO.getPrice() < 0){
            throw new IllegalArgumentException("price must be positive");
        }
        if(goodsRepository.existsByName(goodsDTO.getName())){
            Goods goods = goodsRepository.findByName(goodsDTO.getName());
            goods.setCount(goods.getCount() + goodsDTO.getCount());
            goodsRepository.save(goods);
            return;
        }

        goodsRepository.save(Goods.fromDTO(goodsDTO));
    }

    @Transactional(readOnly = true)
    @Override
    public List<GoodsDTO> getGoods(Pageable pageable,String manufacturer, String name, String type, int min, int max) {

        QGoods goods = QGoods.goods;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(manufacturer != null){
            booleanBuilder.and(goods.manufacturer.eq(manufacturer));
        }
        if(name != null){
            booleanBuilder.and(goods.name.eq(name));
        }
        if(type != null){
            booleanBuilder.and(goods.type.eq(type));
        }
        booleanBuilder.and(goods.price.between(min,max));
        List<Goods> list = goodsRepository.findAll(booleanBuilder,pageable).getContent();
        List<GoodsDTO> res = new ArrayList<>();

        for (Goods loc : list)
            res.add(loc.toDTO());

        return res;
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return goodsRepository.count();
    }

}
