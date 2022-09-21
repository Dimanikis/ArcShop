package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.model.Goods;
import arc.ua.arcshop.repository.GoodsRepository;
import org.springframework.data.domain.Pageable;
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
    public void addGoods(GoodsDTO goodsDTO){
        if(goodsRepository.existsByName(goodsDTO.getName())){
            Goods goods = goodsRepository.findByName(goodsDTO.getName());
            goods.setCount(goods.getCount() + goodsDTO.getCount());
            goodsRepository.save(goods);
            return;
        }

        goodsRepository.save(Goods.fromDTO(goodsDTO));
    }

    @Transactional(readOnly = true)
    public List<GoodsDTO> getGoods(Pageable pageable) {
        List<Goods> list = goodsRepository.findAll(pageable).getContent();
        List<GoodsDTO> res = new ArrayList<>();

        for (Goods loc : list)
            res.add(loc.toDTO());

        return res;
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return goodsRepository.count();
    }

}
