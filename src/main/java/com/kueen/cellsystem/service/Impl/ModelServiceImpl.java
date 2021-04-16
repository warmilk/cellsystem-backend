package com.kueen.cellsystem.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kueen.cellsystem.dao.ModelMapper;
import com.kueen.cellsystem.dao.RegionMapper;
import com.kueen.cellsystem.entity.ModelCheckParam;
import com.kueen.cellsystem.entity.ModelCheckQueryParam;
import com.kueen.cellsystem.entity.ModelDetail;
import com.kueen.cellsystem.service.CellService;
import com.kueen.cellsystem.service.ModelService;
import com.kueen.cellsystem.service.RegionService;
import com.kueen.cellsystem.util.WsSessionManager;
import com.kueen.cellsystem.util.WsThreadManager;
import com.kueen.cellsystem.util.api.CommandParam;
import com.kueen.cellsystem.util.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.swing.plaf.synth.Region;
import java.io.IOException;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CellService cellService;


    @Override
    public List<ModelDetail> getAll() {
        return modelMapper.getAll();
    }

    @Override
    public CommonResult check(ModelCheckParam modelCheckParam) {
        WebSocketSession session = WsSessionManager.get(modelCheckParam.getModelId()+"");
        if (session == null) {
            return CommonResult.failed();
        }
        Thread thread = Thread.currentThread();
        ModelCheckQueryParam modelCheckQueryParam = new ModelCheckQueryParam();
        modelCheckQueryParam.setThread(thread.toString());
        for (int i = 0; i < modelCheckParam.getSliceNum(); i++) {
            modelCheckQueryParam.setSliceUrl("slice/" + modelCheckParam.getSliceId() + "/" + i + ".jpg");
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
            String filename = "./slice/" + modelCheckParam.getSliceId() + "/" + i + ".json";
            cellService.modifyCell(filename, msg.getString("data"));
        }
        return CommonResult.success(null);
    }
}
