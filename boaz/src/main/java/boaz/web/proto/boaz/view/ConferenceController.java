package boaz.web.proto.boaz.view;

import boaz.web.proto.boaz.domain.BoazSession;
import boaz.web.proto.boaz.domain.Conference;
import boaz.web.proto.boaz.service.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author 12기 남궁찬
 */
@RestController
@RequestMapping("/conference")
public class ConferenceController {
    private static final String LOCATION_PATH = "/admin/conference";
    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/{session}/{page}")
    public ResponseEntity<List<Conference>> conferencePage(@PathVariable BoazSession session,
                                                           @PathVariable int page) {
        return ResponseEntity.ok(conferenceService.getList(page, session));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> conferenceDetailPage(@PathVariable long id) {
        return ResponseEntity.ok(conferenceService.getById(id));
    }

    @PostMapping("/post")
    public ResponseEntity<String> uploadConference(@RequestBody Conference conference){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath(LOCATION_PATH).build().toUri();

        boolean isSaved = conferenceService.save(conference);
        if (isSaved) {
            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.accepted().location(location).body("Fail to save");
        }
    }

    @PostMapping("/modify")
    public ResponseEntity<String> modifyConference(@RequestBody Conference conference){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath(LOCATION_PATH).build().toUri();

        boolean isUpdated = conferenceService.update(conference);
        if (isUpdated) {
            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.accepted().location(location).body("Fail to Modify");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteConference(@RequestBody long id) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath(LOCATION_PATH).build().toUri();

        boolean isDeleted = conferenceService.deleteConferenceById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().location(location).build();
        } else {
            return ResponseEntity.accepted().location(location).body("Fail to Delete");
        }

    }

}
