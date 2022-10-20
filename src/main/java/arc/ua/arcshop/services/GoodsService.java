package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.GoodsDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {

    List<GoodsDTO> getGoods(Pageable pageable,String manufacturer, String name, String type, int min, int max);

    boolean addGoods(GoodsDTO goodsDTO);

    boolean updateGoods(GoodsDTO goodsDTO);

    void deleteGoods(List<Long> idList);

    long count();

}
