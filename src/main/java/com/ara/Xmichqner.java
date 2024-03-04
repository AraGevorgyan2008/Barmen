package com.ara;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Xmichqner {
    private String name ;
    private int price;
    private String description;
    private List<Integer> ingredientCostList;
    private boolean alcho ;
    private boolean shakeNoShake;
    private int drink_id ;
    private String img ;
    private boolean available ;
    private boolean bnakanDrink ;
}
