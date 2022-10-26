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
    private String manufacturer;
    private Double price;
    private Integer count;

    public static GoodsDTO of(String name, String type, String manufacturer, Double price, Integer count){
        return new GoodsDTO(null, name, type, manufacturer, price, count);
    }
    public static GoodsDTO of(Long id, String name, String type, String manufacturer, Double price, Integer count) {
        return new GoodsDTO(id, name, type, manufacturer, price, count);
    }
}
