package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.dto.GoodsShortDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {

    List<GoodsShortDTO> getGoods(Pageable pageable, String name, String type, int min, int max);

    GoodsDTO getGood(long id);

    boolean addGoods(GoodsDTO goodsDTO);

    boolean updateGoods(GoodsDTO goodsDTO);

    void deleteGoods(List<Long> idList);

    long count();

}
