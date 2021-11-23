package com.kuang.kuangshenesjd.controller;

import com.kuang.kuangshenesjd.pojo.Content;
import com.kuang.kuangshenesjd.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
 * @description:前端的请求编写
 * @author: Felix_XHF
 * @create:2021-11-23 20:18
 */
@RestController
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("parse/{keyword}")
    public Boolean parse(@PathVariable("keyword") String keyword) throws IOException {
        return contentService.parseContent(keyword);
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(@PathVariable("keyword")String keyword,@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize) throws IOException {
        return contentService.searchPageHighlightBuilder(keyword,pageNo,pageSize);
    }

//    @GetMapping("/searchHigh{keyword}/{pageNo}/{pageSize}")
//    public List<Map<String,Object>> searchPageHighlightBuilder(@PathVariable("keyword")String keyword,@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize) throws IOException {
//        return contentService.searchPageHighlightBuilder(keyword,pageNo,pageSize);
//    }
}