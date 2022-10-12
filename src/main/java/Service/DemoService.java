package Service;

import Entity.DemoEntity;
import Repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
private DemoRepository demoRepository;

    public List<DemoEntity> showAll(){
        return demoRepository.findAll();
    }
}
