package ru.gb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

// Конфигурация приложения
// JavaConfig, в котором объявляются бины Spring,
// относящиеся к веб-уровню приложения
@EnableWebMvc   // Включает поддержку аннотаций MVC-компонентов
@Configuration // Указывает что данный класс является конфигурацией
@ComponentScan("ru.gb") // Указывает на пакет в котором хранятся класс-контроллеры
public class AppConfig implements WebMvcConfigurer {

    // Добавляет обработчик ресурсов Метод принимает объект класса
    // ResourceHandlerRegistry и добавляет шаблон пути и локацию. Другими словами, на все
    // запросы /resources/** будет вызываться не контроллер, созданный разработчиком, а
    // возвращаться указанный в запросе файл (например, .css или .js).
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new
                SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    // thymeleafViewResolver() — создает и настраивает бин, который является тем самым ViewResolver.
    // Вспомним: контроллер возвращает только строку имени html-страницы, а
    // DispatcherServlet обращается к данному бину, который формирует полный путь к
    // представлению, прибавляя к его имени параметры, указанные в методах setPrefix и setSuffix.
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
    }
}
