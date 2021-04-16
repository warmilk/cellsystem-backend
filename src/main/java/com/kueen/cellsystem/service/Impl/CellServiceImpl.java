package com.kueen.cellsystem.service.Impl;

import com.kueen.cellsystem.dao.CellMapper;
import com.kueen.cellsystem.dao.ModelMapper;
import com.kueen.cellsystem.entity.CellDetail;
import com.kueen.cellsystem.entity.ModelDetail;
import com.kueen.cellsystem.service.CellService;
import com.kueen.cellsystem.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class CellServiceImpl implements CellService {
    @Autowired
    private CellMapper cellMapper;


    @Override
    public List<CellDetail> getAll() {
        return cellMapper.getAll();
    }

    @Override
    public void modifyCell(String filename, String content) {
        File file = new File(filename);
        try (Writer writer = new FileWriter(file)) {
            char[] data = content.toCharArray();
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
