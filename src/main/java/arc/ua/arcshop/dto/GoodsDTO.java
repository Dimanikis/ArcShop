package arc.ua.arcshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsDTO {

    private String name;
    private String type;
    private String manufacturer;
    private Integer price;
    private Integer count;

    public GoodsDTO(String name,String type, String manufacturer, Integer price, Integer count) {
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
    }

    public static GoodsDTO of(String name, String type, String manufacturer, Integer price, Integer count) {
        return new GoodsDTO(name, type, manufacturer, price, count);
    }
}
