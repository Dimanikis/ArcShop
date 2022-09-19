package arc.ua.arcshop.model;


import arc.ua.arcshop.dto.GoodsDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
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
    private String manufacturer;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Integer count;

    public Goods(String name, String type, String manufacturer, Integer price, Integer count) {
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
    }

    public static Goods of(String name,String type, String manufacturer, Integer price, Integer count) {
        return new Goods(name,type, manufacturer, price, count);
    }

    public static Goods fromDTO(GoodsDTO goodsDTO){
       return Goods.of(goodsDTO.getName(),goodsDTO.getType(),goodsDTO.getManufacturer(),goodsDTO.getPrice(),goodsDTO.getCount());
    }
    public GoodsDTO toDTO() {
        return GoodsDTO.of(name, type, manufacturer, price, count);
    }
}
