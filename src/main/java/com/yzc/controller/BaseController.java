package com.yzc.controller;

/**
 * Created by wangfujie on 2017/5/9.
 */

import com.common.utils.DownloadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * 基础控制类 ，持续扩展
 */
public class BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * ThreadLocal确保高并发下每个请求的request，response都是独立的
     */
    private static ThreadLocal<HttpServletRequest> currentRequest = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> currentResponse = new ThreadLocal<>();
    private static ThreadLocal<HttpSession> currentSession = new ThreadLocal<>();

    @ModelAttribute
    public void initReqAndRep(HttpServletRequest request, HttpServletResponse response) {
        currentRequest.set(request);
        currentResponse.set(response);
        currentSession.set(request.getSession());
    }

    public HttpServletRequest getRequest() {
        return currentRequest.get();
    }

    public HttpServletResponse getResponse() {
        return currentResponse.get();
    }

    public HttpSession getSession() {
        return currentSession.get();
    }

    //    输出文件流
    protected void outFile(HttpServletResponse response, HttpServletRequest request, String filePath, String fileName) {
        if (fileName != null) {
            File file = new File(filePath);
            if (file.exists()) {
                getResponse().setContentType("application/force-download");// 设置强制下载不打开
                try {
                    fileName = DownloadUtils.getDownloadFileName(request.getHeader("user-agent"), fileName);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                try (FileInputStream fis = new FileInputStream(file);
                     BufferedInputStream bis = new BufferedInputStream(fis);
                     OutputStream os = response.getOutputStream()
                ) {
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除临时文件
     *
     * @param filePath
     */
    protected void deleteTmpFile(String filePath) {
        try {
            if (StringUtils.hasLength(filePath)) {
                File tmpFile = new File(filePath);
                if (tmpFile.exists()) {
                    tmpFile.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
