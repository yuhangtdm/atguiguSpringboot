package com.atguigu.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * SpringBoot默认支持两种技术来和ES交互；
 * 1、Jest（默认不生效）
 * 	    1).需要导入jest的工具包（io.searchbox.client.JestClient）
 * 	    2).需要配置 spring.elasticsearch.jest.uris=106.15.188.249:9200 指定es的地址
 * 	    3).注入JestClient操作es
 * 	    4).索引的对象添加@JestId 用Index的Builder指定索引位置和类型
 * 2、SpringData ElasticSearch【ES版本有可能不合适】
 * 		版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 *		如果版本不适配：2.4.6
 *			1）、升级SpringBoot版本
 *			2）、安装对应版本的ES
 *
 * 		1）、Client 节点信息clusterNodes；clusterName
 * 		2）、ElasticsearchTemplate 操作es
 *		3）、编写一个 ElasticsearchRepository 的子接口来操作ES；
 *	两种用法：https://github.com/spring-projects/spring-data-elasticsearch
 *	1）、编写一个 ElasticsearchRepository
 */


/**
 * 1、引入SpringSecurity；
 * 2、编写SpringSecurity的配置类；
 * 		@EnableWebSecurity   extends WebSecurityConfigurerAdapter
 * 3、控制请求的访问权限：
 * 		configure(HttpSecurity http) {
 * 		 	http.authorizeRequests().antMatchers("/").permitAll()
 * 		 		.antMatchers("/level1/**").hasRole("VIP1")
 * 		}
 * 4、定义认证规则：
 * 		configure(AuthenticationManagerBuilder auth){
 * 		 	auth.inMemoryAuthentication()
 * 		 		.withUser("zhangsan").password("123456").roles("VIP1","VIP2")
 * 		}
 * 5、开启自动配置的登陆功能：
 * 		configure(HttpSecurity http){
 * 		 	http.formLogin();
 * 		}
 * 6、注销：http.logout();
 * 7、记住我：Remeberme()；
 */
@SpringBootApplication
public class SpringBootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticsearchApplication.class, args);
    }
}
