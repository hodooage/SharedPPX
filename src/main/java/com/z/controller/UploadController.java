package com.z.controller;

import com.z.pojo.UploadImageFile;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView uploadImage(HttpServletRequest request, UploadImageFile file) throws IOException {
        String name=RandomStringUtils.randomAlphabetic(10);
        String newFileName=name+".jpg";
        File newFile=new File(request.getServletContext().getRealPath("/images"),newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);

        ModelAndView mav=new ModelAndView("showUploadImage");
        mav.addObject("imageName",newFileName);
        System.out.println(newFileName);
        System.out.println(newFile.toPath());

        return mav;
    }
}
