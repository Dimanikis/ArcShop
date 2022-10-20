package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.model.Account;
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
    public boolean addGoods(GoodsDTO goodsDTO){

        if(goodsRepository.existsByName(goodsDTO.getName())){
            return false;
        }

        goodsRepository.save(Goods.fromDTO(goodsDTO));
        return true;
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

        for (Goods g : list)
            res.add(g.toDTO());

        return res;
    }

    @Transactional
    @Override
    public boolean updateGoods(GoodsDTO goodsDTO){
        if( ! goodsRepository.existsByName(goodsDTO.getName()))
            return false;

        goodsRepository.save(Goods.fromDTO(goodsDTO));
        return true;
    }

    @Transactional
    @Override
    public void deleteGoods(List<Long> idList){
        idList.forEach(goodsRepository::deleteById);
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return goodsRepository.count();
    }

}
