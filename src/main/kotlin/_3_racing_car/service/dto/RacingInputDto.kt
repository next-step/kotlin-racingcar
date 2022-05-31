package _3_racing_car.service.dto

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Racer
import _3_racing_car.service.Track

class RacingInputDto(racingInput: Map<Racer, Power>) {
    val tracks: List<Track> = racingInput.map { Track(it.key, it.value) }
}
