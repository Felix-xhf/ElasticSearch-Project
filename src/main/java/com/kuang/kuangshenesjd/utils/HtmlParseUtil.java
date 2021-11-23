package com.kuang.kuangshenesjd.utils;

import com.kuang.kuangshenesjd.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/*
 * @description:爬虫工具类
 * @author: Felix_XHF
 * @create:2021-11-21 19:07
 */
@Component
public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        HtmlParseUtil htmlParseUtil = new HtmlParseUtil();
        htmlParseUtil.parseJD("心理学").forEach(System.out::println);
    }

    public ArrayList<Content> parseJD(String keywords) throws IOException {
        //获取请求 https://search.jd.com/Search?keyword=java
        //前提：需要联网，ajax的数据不能获取到
        String url = "https://search.jd.com/Search?keyword=" + keywords;

        //解析网页(Jsoup返回Document就是Document对象)
        Document document = Jsoup.parse(new URL(url), 30000);
        //所有在JS中可以使用的方法，这里都可以用
        Element element = document.getElementById("J_goodsList");
        System.out.println(element.html());

        //获取所有的li元素
        Elements li = element.getElementsByTag("li");

        ArrayList<Content> goodList = new ArrayList<>();
        //获取元素中的内容,这里的每一个li标签
        for (Element el : li) {
            //关于这种图片特别多的网站，所有的图片都是延迟加载的
            String title = el.getElementsByClass("p-name").eq(0).text();
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String shopnum = el.getElementsByClass("p-shopnum").eq(0).text();

//            System.out.println("===========================================");
//            System.out.println(title);
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(shopnum);

            Content content = new Content();
            content.setTitle(title);
            content.setPrice(price);
            content.setImg(img);
            goodList.add(content);
        }
        return goodList;
    }
}
