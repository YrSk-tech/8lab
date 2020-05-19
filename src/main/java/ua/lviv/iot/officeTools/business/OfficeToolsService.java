package ua.lviv.iot.officeTools.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.officeTools.dataaccess.OfficeToolRepository;
import ua.lviv.iot.officeTools.model.OfficeTool;

@Service
public class OfficeToolsService {
    @Autowired
    private OfficeToolRepository officeToolRepository;

    public OfficeTool createOfficeTool(OfficeTool officeTool) {
        return officeToolRepository.save(officeTool);
    }

    public void deleteOfficeTool(Integer officeToolId) {
        officeToolRepository.deleteById(officeToolId);
    }

    public List<OfficeTool> findOfficeTool() {
        return officeToolRepository.findAll();
    }

    public OfficeTool findPieceOfOfficeTool(Integer officeToolId) {
        return officeToolRepository.findById(officeToolId).get();
    }

    public boolean checkForOfficeToolExistence(Integer officetoolId) {
        return officeToolRepository.existsById(officetoolId);
    }

    public OfficeTool updateOfficeTool(Integer officeToolId, OfficeTool officeTool) {
        OfficeTool previousOfficeTool = officeToolRepository.findById(officeToolId).get();
        OfficeTool officeToolToReturn = new OfficeTool(previousOfficeTool.getProducer(),
                previousOfficeTool.getPriceInUAH(), previousOfficeTool.getWeightInGrams(),
                previousOfficeTool.getWarrantyInDays());
        officeToolToReturn.setId(officeToolId);
        officeTool.setId(officeToolId);
        officeToolRepository.save(officeTool);
        return officeToolToReturn;
    }
}
