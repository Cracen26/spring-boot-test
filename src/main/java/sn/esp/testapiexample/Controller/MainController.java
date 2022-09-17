package sn.esp.testapiexample.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/home")
public class MainController {
    @GetMapping
    public String getHome(){
        return "Hello";
    }

    
    @GetMapping(value = "/json",produces =MediaType.APPLICATION_JSON_VALUE )
    public Hello returnJson(){
        return new Hello("TestJson","Hello guys");
    }

    @AllArgsConstructor
    @Setter
    @Getter
    private class Hello{
        private String title;
        private String value;
    }

}
