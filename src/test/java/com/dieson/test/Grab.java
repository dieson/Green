package com.dieson.test;

import com.dieson.green.utils.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Grab
 * @Description: 获取百度页面图片
 * @author: Dieson Zuo
 * @date: Created in 8:28 2018/11/12
 */
public class Grab {


    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        try {
            Request request = Request.Get(url);
            HttpResponse response = request.execute().returnResponse();
            String result = StringUtils.unicodeToString(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));

            List<String> imgUrlList = Grab.getImgUrl(result);
            Grab.downloadImage(imgUrlList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取img url
     * @param content
     * @return
     */
    public static List<String> getImgUrl(String content) {
        Matcher matcher = Pattern.compile("src=(.*?)(.jpg|.jpeg|.gif|.png|.bmp)").matcher(content);

        List<String> imgUrls = new ArrayList<>();
        while (matcher.find()) {
            String url = matcher.group();
            imgUrls.add("http://" + url.substring(url.indexOf("www")));
        }
        return imgUrls;
    }

    /**
     * 下载图片
     * @param imageUrls
     * @throws IOException
     */
    public static void downloadImage(List<String> imageUrls) throws IOException {
        for (String url : imageUrls) {
            String imageName = url.substring(url.lastIndexOf("/") + 1);
            URL uri = new URL(url);
            InputStream in = uri.openStream();

            String path = System.getProperty("user.dir") + File.separator + imageName;
            System.out.println(path);
            FileOutputStream fo = new FileOutputStream(new File(path));

            int len = 0;
            while ((len = in.read()) != -1) {
                fo.write(len);
            }
            in.close();
            fo.close();
        }

    }
}
