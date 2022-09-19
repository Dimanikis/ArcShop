package arc.ua.arcshop.services;

import arc.ua.arcshop.dto.GoodsDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {

    List<GoodsDTO> getGoods();

    void addGoods(GoodsDTO goodsDTO);
}
