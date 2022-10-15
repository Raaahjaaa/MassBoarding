package com.example.demoWebsite.Repository;

import com.example.demoWebsite.Entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity,Long> {

}
