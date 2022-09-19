package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.model.Goods;
import arc.ua.arcshop.repository.GoodsRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

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
    public List<GoodsDTO> getGoods() {
        List<Goods> list = goodsRepository.findAll();
        List<GoodsDTO> res = new ArrayList<>();

        for (Goods loc : list)
            res.add(loc.toDTO());

        return res;
    }

    /*
    public List<GoodsDTO> findGoodsByCriteria(GoodsDTO goodsDTO) {

        Specification<Goods> specification = null;

        where(specification).and(
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("available"), goodsDTO.isAvailable())
        );

        where(specification).and(
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("reserved"), goodsDTO.isReserved)
        );

        List<Goods> goods = goodsRepository.findAll(specification);
    }

     */


}
