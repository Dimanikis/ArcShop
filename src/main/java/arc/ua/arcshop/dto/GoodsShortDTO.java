package arc.ua.arcshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GoodsShortDTO {

    private Long id;
    private String name;
    private String type;
    private Double price;
    private Integer discount;

    public static GoodsShortDTO of(Long id, String name, String type, Double price, Integer discount){
        return new GoodsShortDTO(id, name, type, price, discount);
    }
}
