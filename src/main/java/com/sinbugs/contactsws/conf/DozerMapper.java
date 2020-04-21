package com.sinbugs.contactsws.conf;


import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Marisol on 19/04/2020.
 */
@Configuration
public class DozerMapper {

    @Bean
    public Mapper beanMapper(){
            return new DozerBeanMapper();
    }
}
