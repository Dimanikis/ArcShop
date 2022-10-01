package arc.ua.arcshop.dto;

import lombok.Data;

@Data
public class GoodsDTO {

    private String name;
    private String type;
    private String manufacturer;
    private Double price;
    private Integer count;

    public GoodsDTO(String name,String type, String manufacturer, Double price, Integer count) {
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
    }

    public static GoodsDTO of(String name, String type, String manufacturer, Double price, Integer count) {
        return new GoodsDTO(name, type, manufacturer, price, count);
    }
}
