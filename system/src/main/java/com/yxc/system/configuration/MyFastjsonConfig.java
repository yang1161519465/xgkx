package com.yxc.system.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
/*对fastJson返回的字符串格式进行配置*/
public class MyFastjsonConfig {
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");//日期格式
        config.setCharset(Charset.forName("UTF-8"));//数据编码
        config.setSerializerFeatures(
//                SerializerFeature.WriteClassName,//是否在生成的json中输出类名
                SerializerFeature.WriteMapNullValue,//是否输出value为null的字符串
                SerializerFeature.PrettyFormat,//生成的json格式化
                SerializerFeature.WriteNullListAsEmpty,//空集合输出【】而非null
                SerializerFeature.WriteNullStringAsEmpty//空字符串输出“”而不是null
        );
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

        //配置完之后还需要在config里面响应一下编码
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        return fastJsonHttpMessageConverter;
    }
}