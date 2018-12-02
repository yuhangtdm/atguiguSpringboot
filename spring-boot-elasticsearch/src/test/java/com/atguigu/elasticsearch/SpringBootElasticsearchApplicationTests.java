package com.atguigu.elasticsearch;

import com.atguigu.elasticsearch.bean.Article;
import com.atguigu.elasticsearch.bean.Book;
import com.atguigu.elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    BookRepository bookRepository;

    /**
     * 添加一个索引 jestClient的方式
     */
    @Test
    public void testJest1() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("这是一个好消息");
        article.setAuthor("dity");
        article.setContent("Hello World");
        //指定要索引的对象 指定索引 指定类型
        Index index=new Index.Builder(article).index("atguigu").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一个索引 jestClient的方式
     */
    @Test
    public void testJest2() {
        String json ="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //指定要索引的对象 指定索引 指定类型
        Search search=new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSpringData1(){
        boolean atguigu = elasticsearchTemplate.createIndex("atguigu");
        Client client = elasticsearchTemplate.getClient();
//        client.

    }

    @Test
    public void testSpringData2(){
        Book book=new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.save(book);
    }

    @Test
    public void testSpringData3(){

        Book one = bookRepository.findOne(1);
        System.out.println(one);

    }

    @Test
    public void testSpringData4(){

        List<Book> books = bookRepository.findByBookNameLike("游");
        System.out.println(books);

    }


}
