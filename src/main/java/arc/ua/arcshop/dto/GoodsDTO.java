package arc.ua.arcshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GoodsDTO {

    private Long id;
    private String name;
    private String type;
    private Double price;
    private Integer discount;
    private String description;
    private String aDescription;
    private String review;
    private Integer count;

    public static GoodsDTO of(String name, String type, Double price, Integer discount, String description, String aDescription, String review, Integer count){
        return new GoodsDTO(null, name, type, price, discount, description, aDescription, review, count);
    }
    public static GoodsDTO of(Long id, String name, String type, Double price, Integer discount, String description, String aDescription, String review, Integer count) {
        return new GoodsDTO(id, name, type, price, discount, description, aDescription, review, count);
    }
}
