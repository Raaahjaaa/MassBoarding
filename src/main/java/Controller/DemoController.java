package Controller;

import Entity.DemoEntity;
import Service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/getData")
    public List<DemoEntity> getData(){
        return demoService.showAll();
    }
}
