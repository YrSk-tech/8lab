package ua.lviv.iot.officeTools.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.officeTools.business.OfficeToolsService;
import ua.lviv.iot.officeTools.model.OfficeTool;

@RequestMapping("/officetool")
@RestController
public class OfficeToolController {
    private static AtomicInteger IdCounter = new AtomicInteger();
    @Autowired
    private OfficeToolsService officeToolsService;

    @GetMapping
    public List<OfficeTool> getOfficeTool() {
        return new LinkedList<OfficeTool>(officeToolsService.findOfficeTool());
    }

    @GetMapping(path = "/{id}")
    public OfficeTool getOfficeTool(final @PathVariable("id") Integer officeToolId) {
        return officeToolsService.findPieceOfOfficeTool(officeToolId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<OfficeTool> getPartOfOfficeTool(final @PathVariable("id") Integer officeToolId,
            final @RequestBody OfficeTool officetool) {
        officetool.setId(officeToolId);
        if (officeToolsService.checkForOfficeToolExistence(officeToolId)) {
            return ResponseEntity.ok(officeToolsService.updateOfficeTool(officeToolId, officetool));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<OfficeTool> deleteOfficeTool(final @PathVariable("id") Integer officeToolId) {
        if (officeToolsService.checkForOfficeToolExistence(officeToolId)) {
            officeToolsService.deleteOfficeTool(officeToolId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public OfficeTool createOfficeTool(final @RequestBody OfficeTool officeTool) {
        officeTool.setId(IdCounter.incrementAndGet());
        officeToolsService.createOfficeTool(officeTool);
        return officeTool;
    }
}