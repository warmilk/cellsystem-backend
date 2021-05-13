package com.kueen.cellsystem.controller;
import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.ModelCheckQueryParam;
import com.kueen.cellsystem.service.ModelService;
import com.kueen.cellsystem.service.PatientService;
import com.kueen.cellsystem.util.FileUtil;
import com.kueen.cellsystem.util.api.CommonResult;
import com.kueen.cellsystem.service.FileService;
import com.kueen.cellsystem.service.CellprofilerService;
import com.kueen.cellsystem.entity.IdentifyParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.kueen.cellsystem.util.FileUtil;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
@RequestMapping("/msg")
public class InputMessageCellImgController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private CellprofilerService cellprofilerService;
    @Autowired
    private ModelService modelService;
    @Value("${model.port}")
    private int modelPort;
    @Autowired
    private FileService fileService; //之所以import了FileService进来还需要@Autowired private FileService fileService; ，是因为不写这个的话，下面的FileDetail fileDetail = fileService.uploadImgFile(file); 会报错【无法从静态上下文中引用非静态方法】需要手动new实例化对象才能用 https://www.jianshu.com/p/203d03f98aa6

    @RequestMapping(value = "/modifiy", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult formUpload(@RequestBody  Map<String, Map<String,Object>> requestBodyData) {
        Map<String, Object> object1 = requestBodyData.get("object1");
        Map<String, Object> object2 = requestBodyData.get("object2");
        Map<String, Object> object3 = requestBodyData.get("object3");
        Map<String, Object> object4 = requestBodyData.get("object4");
        //String url= (String) object1.get("imgUrl").toString();

        //String imgUrl = FileUtil.base64Decode(url);
        /* 识别细胞核*/
        /*Double NucleusMax = (Double) object1.get("Max")*1.0;
        Double NucleusMin = (Double) object1.get("Min")*1.0;
        boolean excludeBorderObjects= (boolean) object1.get("excludeBorderObjects");
        boolean excludeSize= (boolean) object1.get("excludeSize");
        String imgUrl=(String)object1.get("imgUrl");
        String inputImgName=(String)object1.get("inputImgName");
        //识别细胞体参数
        double cellBodyMax = (double) object2.get("Max")*1.0;
        double cellBodyMin = (double) object2.get("Min")*1.0;
        //double regularization_factor = (double) object2.get("regularization_factor")*1.0;
        //double threshold_correction_factor = (double) object2.get("threshold_correction_factor")*1.0;
        //double threshold_smoothing_scale = (double) object2.get("threshold_smoothing_scale")*1.0;
        boolean fill_holes= (boolean) object2.get("fill_holes");
        boolean wants_discard_edge= (boolean) object2.get("wants_discard_edge");
        String o2inputImgName=(String)object2.get("inputImgName");
        String threshold_scope=(String)object2.get("threshold_scope");

        //计算模型参数
        //boolean calculate_advanced=(boolean)object3.get("calculate_advanced");
        //boolean calculate_zernikes=(boolean)object3.get("calculate_zernikes");
        输出参数*/
        String output_pathname=(String)object3.get("output_pathname");
        String save_pathname=(String)object3.get("save_pathname");
        System.out.println(object1.get("imgUrl"));



        ModelCheckQueryParam modelCheckQueryParam = new ModelCheckQueryParam();
        ModelCheckParam modelCheckParam=new ModelCheckParam();
        modelCheckParam.setModelId(1);
        CommonResult commonResult = cellprofilerService.check(modelCheckParam,requestBodyData);
        return CommonResult.success(commonResult);
    }

    @RequestMapping(value = "/get/{imgFullPath}", method = RequestMethod.GET)
    @ResponseBody
    public void fileAccess(HttpServletResponse response, @PathVariable String imgFullPath) {
        fileService.accessImgFile(response, imgFullPath);
    }

}
