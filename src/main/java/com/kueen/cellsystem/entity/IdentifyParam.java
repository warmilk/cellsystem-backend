package com.kueen.cellsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IdentifyParam {
    public static class Object1 {
        private static String imgUrl;
        private String inputImgName;
        private Boolean excludeBorderObjects;
        private Boolean excludeSize;
        private Double Max;
        private Double Min;
    }

    public class Object2 {
    }

    public class Object3 {
    }

    public class Object4 {
    }

    private Object1 object1 = new Object1();
    private Object2 object2 = new Object2();
    private Object3 object3 = new Object3();
    private Object4 object4 = new Object4();
}
