package com.ecm.common;

import static com.ecm.common.ViewConstants.SAVE_LOCATION;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtility {

    public String getAbsoluteImagePath(CommonsMultipartFile str, long id, String folder) throws IOException {
        String controllerPath = "";
        String filePath = "";
        controllerPath = folder + "/" + id;
        filePath = SAVE_LOCATION + "/" + controllerPath + "/";
        CommonsMultipartFile imageFile = str;
        //System.out.println("Original File Name : "+imageFile.getOriginalFilename());
        File file = null;
        if (imageFile!=null && imageFile.getOriginalFilename()!=null && !imageFile.getOriginalFilename().trim().equals("")) {
            try {
                String fileName = imageFile.getOriginalFilename();
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File[] files = dir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
                file = new File(filePath + fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                imageFile.transferTo(file);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return controllerPath;

    }
    
    public String getAbsoluteImagePath(MultipartFile str, long id, String folder) throws IOException {
        String controllerPath = "";
        String filePath = "";
        controllerPath = folder + "/" + id;
        filePath = SAVE_LOCATION + "/" + controllerPath + "/";
        MultipartFile imageFile = str;
        //System.out.println("Original File Name : "+imageFile.getOriginalFilename());
        File file = null;
        if (!imageFile.getOriginalFilename().trim().equals("")) {
            try {
                String fileName = imageFile.getOriginalFilename();
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File[] files = dir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
                file = new File(filePath + fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                imageFile.transferTo(file);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return controllerPath;
    }
    
    
    public String Base64ToImage(String imageStr, String imageStr2,long id, String folder) throws IOException{
        String controllerPath = "";
        String filePath = "";
        controllerPath = folder + "/" + id;
        filePath = SAVE_LOCATION + "/" + controllerPath + "/";
        
        String removeDFirst =imageStr.replaceAll("\\s{2}","++");
        String removeThird=removeDFirst.replaceAll("\\s{3}","+++");
        String firstOutput =removeThird.replaceAll("\\s","+");
        String removeDsecond =imageStr2.replaceAll("\\s{2}","++");
        String removeSecondThird=removeDsecond.replaceAll("\\s{3}","+++");
        String secondOutput=removeSecondThird.replaceAll("\\s","+");
        
        byte[] mim = new byte[300000];
        mim=Base64.getMimeDecoder().decode(firstOutput+secondOutput);
        FileOutputStream fileOuputStream;
        if (!mim.equals("")) {
            try {
                String fileName = "profilePic.png";
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                fileOuputStream = new FileOutputStream(filePath + fileName);
                try {
                    fileOuputStream.write(mim);
                   } catch (IOException e) {
                    e.printStackTrace();
                  }
                try {
                    fileOuputStream.close();
                 } catch (IOException e) {
                    e.printStackTrace();
                 }
              } catch (FileNotFoundException e) {
                e.printStackTrace();
            }           
         }
        return controllerPath;
        
    }

    public static Object setImageURL(Class myClass, Object obj, String methodName) throws Exception {
        ImageUtility imu = new ImageUtility();
        Method getId = myClass.getDeclaredMethod("getId", new Class[] {});
        Long result = (Long) getId.invoke(obj, null);

        Method getImageFile = null;

        getImageFile = myClass.getDeclaredMethod(methodName, new Class[] {});
        CommonsMultipartFile imageFile = (CommonsMultipartFile) getImageFile.invoke(obj, null);
        myClass.getDeclaredMethod("setImage", new Class[] { String.class }).invoke(obj,
                imu.getAbsoluteImagePath(imageFile, result, myClass.getSimpleName().toLowerCase()));
        return obj;

    }

    public static void writeFile(String fileLocation, HttpServletResponse response, String contentType) throws IOException {
        BufferedInputStream bin = null;
        bin = new BufferedInputStream(new FileInputStream(new File(fileLocation)));
        response.setContentType(contentType);
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        BufferedOutputStream bout = new BufferedOutputStream(response.getOutputStream());
        int ch = 0;
        while ((ch = bin.read()) != -1) {
            bout.write(ch);
        }
        bin.close();
        bout.flush();
    }

    public static void writeFile(File file, HttpServletResponse response, String contentType) throws IOException {
        BufferedInputStream bin = null;
        if (file != null && file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            if (inputStream != null) {
                bin = new BufferedInputStream(inputStream);
                response.setContentType(contentType);
                response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
                BufferedOutputStream bout = new BufferedOutputStream(response.getOutputStream());
                int ch = 0;
                while ((ch = bin.read()) != -1) {
                    bout.write(ch);
                }
                bin.close();
                bout.flush();
            }
        }
    }
    //Subject multiple documents
    
    public String[] getAbsoluteImagePathWithFileName(MultipartFile multipartFile, long id, String folder) throws IOException {
        String controllerPath = "";
        String filePath = "";
        controllerPath = folder + "/" + id;
        filePath = SAVE_LOCATION + "/" + controllerPath + "/";
        MultipartFile imageFile = multipartFile;
        //System.out.println("Original File Name : "+imageFile.getOriginalFilename());
        File file = null;
        String fileName = "";
        String retArr[] = new String[2];
        if (!imageFile.getOriginalFilename().trim().equals("")) {
            try {
                fileName = imageFile.getOriginalFilename();
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File[] files = dir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
                file = new File(filePath + fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                imageFile.transferTo(file);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        retArr[0]=controllerPath;
        retArr[1]=fileName;
        return retArr;

    }
    
    public String[] getAbsoluteImagePathAr(CommonsMultipartFile str, long id, String folder) throws IOException {
        String controllerPath = "";
        String filePath = "";
        controllerPath = folder + "/" + id;
        filePath = SAVE_LOCATION + "/" + controllerPath + "/";
        CommonsMultipartFile imageFile = str;
        //System.out.println("Original File Name : "+imageFile.getOriginalFilename());
        File file = null;
        String fileName = "";
        String retArr[] = new String[2];
        if (!imageFile.getOriginalFilename().trim().equals("")) {
            try {
                fileName = imageFile.getOriginalFilename();
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File[] files = dir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
                file = new File(filePath + fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                imageFile.transferTo(file);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        retArr[0]=controllerPath;
        retArr[1]=fileName;
        return retArr;

    }
    
}
