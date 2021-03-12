package boaz.web.proto.boaz.service;

import boaz.web.proto.boaz.domain.BoazSession;
import boaz.web.proto.boaz.domain.Conference;
import boaz.web.proto.boaz.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 12기 남궁찬
 */
@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> getConferenceList(int page, BoazSession session) {
    }

    public Conference getConferenceById(long id) {
    }

    /**
     *
     * @param conference
     * @return isSuccess
     */
    public boolean saveConference(Conference conference) {
    }

    public boolean updadeConference(Conference conference) {
    }

    public boolean deleteConferenceById(long id) {
    }
}
