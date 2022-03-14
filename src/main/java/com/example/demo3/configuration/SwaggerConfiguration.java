package com.example.demo3.configuration;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Collections.singletonList("application/json"/*,"application/xml"*/));
    @Bean
    @Primary
    public Docket api(final TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .enable(true);
/*                .globalRequestParameters(headerParameters());*/
    }

    /*private List<RequestParameter> headerParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("channel")
                .description("Environment used for login ('MOB' or 'WEB' ) ")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(true)
                .build());

        parameters.add(new RequestParameterBuilder()
                .name("Device")
                .description("Used to define device")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(true)
                .build());

        parameters.add(new RequestParameterBuilder()
                .name("Authorization")
                .description("Bearer your_token ")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .build());
        // Uuid header
        parameters.add(new RequestParameterBuilder()
                .name("Uuid")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .build());
        // language Header
        parameters.add(new RequestParameterBuilder()
                .name("language")
                .description("Used to define user agent language")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
        return parameters;
    }*/
}
