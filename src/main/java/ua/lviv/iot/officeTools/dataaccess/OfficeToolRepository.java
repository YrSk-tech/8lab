package ua.lviv.iot.officeTools.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.officeTools.model.OfficeTool;

@Repository
public interface OfficeToolRepository extends JpaRepository<OfficeTool, Integer> {
    
}
