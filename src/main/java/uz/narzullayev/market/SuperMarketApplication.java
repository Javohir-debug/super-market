package uz.narzullayev.market;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;

@SpringBootApplication
public class SuperMarketApplication {

    public static void main(String[] args) throws IOException {
        FileSystemResource resource= new FileSystemResource("src/main/resources/data");
        System.out.println(resource.getURL());
        System.out.println(resource.getURI());
        FileUtils.forceMkdir(resource.getFile());
        SpringApplication.run(SuperMarketApplication.class, args);
    }

}
