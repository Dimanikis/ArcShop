package arc.ua.arcshop.repository;

import arc.ua.arcshop.model.Goods;
import com.querydsl.core.types.QMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GoodsRepository extends JpaRepository<Goods, Long>, QuerydslPredicateExecutor<Goods> {
    boolean existsByName (String name);

    Goods findByName(String name);




}
