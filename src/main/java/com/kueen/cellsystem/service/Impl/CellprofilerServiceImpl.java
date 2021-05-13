package com.kueen.cellsystem.service.Impl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kueen.cellsystem.dao.ModelMapper;
import com.kueen.cellsystem.dao.RegionMapper;
import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.ModelCheckQueryParam;
import com.kueen.cellsystem.entity.ModelDetail;
import com.kueen.cellsystem.service.ModelService;
import com.kueen.cellsystem.util.FileUtil;
import com.kueen.cellsystem.util.WsSessionManager;
import com.kueen.cellsystem.util.WsThreadManager;
import com.kueen.cellsystem.util.api.CommandParam;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import com.kueen.cellsystem.service.CellprofilerService;
import javax.swing.plaf.synth.Region;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CellprofilerServiceImpl implements CellprofilerService {

    @Autowired
    private CellprofilerService cellprofilerService;

    @Override
    public ModelCheckQueryParam packageObjectParam(Map<String, Map<String,Object>> requestBodyData){

        Map<String, Object> object1 = requestBodyData.get("object1");
        Map<String, Object> object2 = requestBodyData.get("object2");
        Map<String, Object> object3 = requestBodyData.get("object3");
        Map<String, Object> object4 = requestBodyData.get("object4");
        ModelCheckQueryParam modelCheckQueryParam = new ModelCheckQueryParam();
        String url= (String) object1.get("imgUrl").toString();

        //String imgUrl = FileUtil.base64Decode(url);
        /* 识别细胞核*/
        Double NucleusMax = Double.valueOf(object1.get("Max").toString());
        Double NucleusMin = Double.valueOf(object1.get("Min").toString());
        Boolean excludeBorderObjects= (Boolean) object1.get("excludeBorderObjects");
        Boolean excludeSize= (Boolean) object1.get("excludeSize");
        String imgUrlOf1=(String)object1.get("imgUrl");
        String inputImgName=(String)object1.get("inputImgName");

        modelCheckQueryParam.setNucleusMax(NucleusMax);
        modelCheckQueryParam.setNucleusMin(NucleusMin);
        modelCheckQueryParam.setExcludeBorderObjects(excludeBorderObjects);
        modelCheckQueryParam.setExcludeSize(excludeSize);
        modelCheckQueryParam.setImgUrlOf1(imgUrlOf1);
        modelCheckQueryParam.setInputImgName(inputImgName);
        //识别细胞体参数
        String imgUrlOf2=(String)object2.get("imgUrl");
        //String imgUrlOf2 = FileUtil.base64Decode(imgUrl);
        Double cellBodyMax = Double.valueOf(object2.get("Max").toString());
        Double cellBodyMin = Double.valueOf(object2.get("Min").toString());
        Double regularization_factor = Double.valueOf(object2.get("regularization_factor").toString());
        Double threshold_correction_factor = Double.valueOf(object2.get("threshold_correction_factor").toString());
        Double threshold_smoothing_scale = Double.valueOf(object2.get("threshold_smoothing_scale").toString());
        Boolean fill_holes= (Boolean) object2.get("fill_holes");
        Boolean wants_discard_edge= (Boolean) object2.get("wants_discard_edge");
        String o2inputImgName=(String)object2.get("inputImgName");
        String threshold_scope=(String)object2.get("threshold_scope");

        modelCheckQueryParam.setImgUrlOf2(imgUrlOf2);
        modelCheckQueryParam.setCellBodyMax(cellBodyMax);
        modelCheckQueryParam.setCellBodyMin(cellBodyMin);
        modelCheckQueryParam.setRegularization_factor(regularization_factor);
        modelCheckQueryParam.setThreshold_correction_factor(threshold_correction_factor);
        modelCheckQueryParam.setThreshold_smoothing_scale(threshold_smoothing_scale);
        modelCheckQueryParam.setFill_holes(fill_holes);
        modelCheckQueryParam.setWants_discard_edge(wants_discard_edge);
        modelCheckQueryParam.setO2inputImgName(o2inputImgName);
        modelCheckQueryParam.setThreshold_scope(threshold_scope);

        //计算模型参数
        Boolean calculate_advanced=(Boolean)object3.get("calculate_advanced");
        Boolean calculate_zernikes=(Boolean)object3.get("calculate_zernikes");

        modelCheckQueryParam.setCalculate_advanced(calculate_advanced);
        modelCheckQueryParam.setCalculate_zernikes(calculate_zernikes);
        /*输出参数*/
        String output_image_name=(String)object4.get("output_image_name");
        String save_pathname=(String)object4.get("save_pathname");

        modelCheckQueryParam.setOutput_image_name(output_image_name);
        modelCheckQueryParam.setSave_pathname(save_pathname);


        return modelCheckQueryParam;
    }

    @Override
    public CommonResult check(ModelCheckParam modelCheckParam,Map<String, Map<String,Object>> requestBodyData) {
        ModelCheckQueryParam modelCheckQueryParam = new ModelCheckQueryParam();
//
        modelCheckQueryParam=packageObjectParam(requestBodyData);
        WebSocketSession session = WsSessionManager.get(modelCheckParam.getModelId()+"");
        modelCheckParam.setSliceNum(1);
        if (session == null) {
            return CommonResult.failed();
        }
        Thread thread = Thread.currentThread();

//
        modelCheckQueryParam.setThread(thread.toString());
        //modelCheckQueryParam.setCalculate_advanced(Boolean.TRUE);
        //modelCheckQueryParam.setSliceUrl("slice/" + modelCheckParam.getSliceId() + "/" +  ".jpg");
        try {
            session.sendMessage(new TextMessage(CommandParam.handle(modelCheckQueryParam).toString()));
            WsThreadManager.add(thread.toString(), thread);
            synchronized(thread) {
                thread.wait();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.failed();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return CommonResult.failed();
        }
        JSONObject msg = WsThreadManager.removeObject(thread.toString());
        if (msg.getIntValue("code") != 200) {
            return CommonResult.failed();
        }
        JSONArray res=msg.getJSONArray("data");
        System.out.println(res.getJSONArray(0).get(1));
        String filename = "./slice/" + modelCheckParam.getSliceId() + "/" + ".json";
        //cellprofilerService.modifyCell(filename, msg.getString("data"));
        return CommonResult.success(res);
    }
}
