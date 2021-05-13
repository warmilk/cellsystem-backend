package com.kueen.cellsystem.entity;

import lombok.Data;

@Data
public class ModelCheckQueryParam {

    private String thread;
    //private String sliceUrl;
    private int modelId;

    private Double NucleusMax ;
    private Double NucleusMin ;
    private Boolean excludeBorderObjects ;
    private Boolean excludeSize ;
    private String imgUrlOf1 ;
    private String imgUrlOf2 ;

    private String inputImgName ;
    //识别细胞体参数
    private Double cellBodyMax ;
    private Double cellBodyMin ;
    private Double regularization_factor ;
    private Double threshold_correction_factor ;
    private Double threshold_smoothing_scale ;
    private Boolean fill_holes ;
    private Boolean wants_discard_edge ;
    private String o2inputImgName ;
    private String threshold_scope ;
    //计算模型参数
    private Boolean calculate_advanced;
    private Boolean calculate_zernikes;
    /*输出参数*/
    private String output_image_name;
    private String save_pathname;

}
