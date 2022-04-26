package com.cursojava.curso.controllers;

import com.cursojava.curso.entities.WebPage;
import com.cursojava.curso.services.SearchService;
import com.cursojava.curso.services.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private SearchService service;

    @Autowired
    private SpiderService spiderService;

    @RequestMapping(value = "api/search", method = RequestMethod.GET)
    public List<WebPage> search(@RequestParam Map<String, String> params) {
       String query = params.get("query");
        return service.search(query);
    }


    @RequestMapping(value = "api/test", method = RequestMethod.GET)
    public void test() {
        spiderService.indexWebPages();
    }
}
