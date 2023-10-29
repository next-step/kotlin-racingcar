package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.domain.RacingTrack

object RacingTrackService {

    fun createRacingTrack(trackName: String): RacingTrack {
        return RacingTrack.of(trackName = trackName)
    }

}
