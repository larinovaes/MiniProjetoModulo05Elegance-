package br.com.zup.MiniProjetoModulo05Elegance.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Modelmapper {

    @Bean
    public ModelMapper modelMapper() {
       return new ModelMapper();
    }
}
