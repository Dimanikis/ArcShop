package arc.ua.arcshop.repository;

import arc.ua.arcshop.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {
    boolean existsByName (String name);

    Goods findByName(String name);
}
