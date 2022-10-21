package arc.ua.arcshop.dto;

import lombok.Data;

@Data
public class GoodsDTO {

    private Long id;
    private String name;
    private String type;
    private String manufacturer;
    private Double price;
    private Integer count;

    public GoodsDTO(Long id,String name,String type, String manufacturer, Double price, Integer count) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
    }

    public static GoodsDTO of(String name, String type, String manufacturer, Double price, Integer count){
        return new GoodsDTO(null, name, type, manufacturer, price, count);
    }
    public static GoodsDTO of(Long id, String name, String type, String manufacturer, Double price, Integer count) {
        return new GoodsDTO(id, name, type, manufacturer, price, count);
    }
}
