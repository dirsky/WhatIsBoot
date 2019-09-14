package com.frank.boot.controller;

import com.frank.boot.entities.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class JestTestController {
    @Autowired
    private JestClient jestClient;

    @GetMapping("/jest")
    public void test() {
        Article article = new Article(
                2,"author","title","content"
        );

        Index build = new Index.Builder(article).index("frank").type("article").id("9").build();

        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/jest_get")
    public String get() {
        String json = "{\n" +
                "  \"query\":{\n" +
                "\t\"match\":{\n" +
                "\t\t\"author\":\"author\"\n" +
                "\t\t}\n" +
                " \t}\n" +
                "}";
        Search build = new Search.Builder(json).addIndex("frank").addType("article").build();
        try {
            SearchResult result = jestClient.execute(build);
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error";

    }

}
