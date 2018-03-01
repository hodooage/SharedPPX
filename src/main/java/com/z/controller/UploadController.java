package com.z.controller;

import com.z.pojo.UploadImageFile;
import com.z.service.UserService;
import com.z.utils.ServiceUrl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @Autowired
    UserService userService;


    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(HttpServletRequest request, UploadImageFile file) throws IOException {
        System.out.println(request.getParameter("userId"));

        String name=RandomStringUtils.randomAlphabetic(10);
        String newFileName=name+".jpg";
        File newFile=new File(request.getServletContext().getRealPath("/images"),newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        ModelAndView mav=new ModelAndView("showUploadImage");
        mav.addObject("imageName",newFileName);

        System.out.println(newFileName);
        System.out.println(newFile.toPath());


        int userId=Integer.parseInt(request.getParameter("userId"));
        String imageUrl= ServiceUrl.IP
                +":"+ServiceUrl.PORT
                +"/"+ServiceUrl.PROJECTNAME
                +"/"+ServiceUrl.IMAGEFILEPACKAGE
                +"/"+newFileName;

        userService.setUserImage(userId,imageUrl);

        return userService.getUserImage(userId);
    }
}
