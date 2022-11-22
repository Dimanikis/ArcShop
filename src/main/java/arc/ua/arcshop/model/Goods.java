package arc.ua.arcshop.model;

import arc.ua.arcshop.dto.GoodsDTO;
import arc.ua.arcshop.dto.GoodsShortDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer discount;

    @Lob
    @Column(nullable = false)
    private String description;

    @Lob
    @Column(nullable = false)
    private String aDescription;

    @Lob
    @Column(nullable = false)
    private String review;
    @Column(nullable = false)
    private Integer count;

    public Goods(String name, String type, Double price, Integer discount, String description, String aDescription, String review, Integer count) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.aDescription = aDescription;
        this.review = review;
        this.count = count;
    }

    public static Goods of(String name, String type, Double price, Integer discount, String description, String aDescription, String review, Integer count) {
        return new Goods(name, type, price, discount, description, aDescription, review, count);
    }

    public GoodsDTO toDTO() {
        return GoodsDTO.of(id, name, type, price, discount, description, aDescription, review, count);
    }

    public static Goods fromDTO(GoodsDTO goodsDTO){
        return of(goodsDTO.getName(), goodsDTO.getType(), goodsDTO.getPrice(), goodsDTO.getDiscount(), goodsDTO.getDescription(), goodsDTO.getADescription(), goodsDTO.getReview(), goodsDTO.getCount());
    }
    public GoodsShortDTO toShortDTO() {
        return GoodsShortDTO.of(id, name, type, price, discount);
    }

}
