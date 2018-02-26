package com.xmair.webapp.controller;

import com.xmair.core.entity.User;
import com.xmair.core.mapper.test1.UserMapper;
import com.xmair.core.util.ResultCodeEnum;
import com.xmair.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;


@Controller
@RequestMapping(value= "/file")
public class FileController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/upload")
    public String index() {
        return "/file/upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/file/uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String filename=file.getOriginalFilename();
            User user=new User();
            user.setId(new Random().nextInt());
            user.setAge(12);
            user.setName(filename);
            user.setPhoto(bytes);

            userMapper.insert(user);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message",
                    e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/file/uploadStatus";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(int id) throws UnsupportedEncodingException
    {
        User user=userMapper.selectByPrimaryKey(id);

        if(user==null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND.toString(),"找不到文件");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition",
                String.format("attachment; filename=\"%s\"",
                        URLEncoder.encode(user.getName(),"UTF-8")));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(user.getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(user.getPhoto());
    }


    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "/file/uploadStatus";
    }
}
