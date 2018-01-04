package cc.wujunyu.web.config;

import cc.wujunyu.web.filter.TimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        bean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        bean.setUrlPatterns(urls);
        return bean;
    }
}
