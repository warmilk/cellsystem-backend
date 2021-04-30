package com.kueen.cellsystem.controller;

import com.kueen.cellsystem.util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/message")
public class MessageController {
    @RequestMapping(value = "/measure", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam String file) {
        return "rrr";
    }
}
