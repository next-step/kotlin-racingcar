package _3_racing_car.service.dto

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Racer
import _3_racing_car.service.Track

class RacingInputDto(private val racingInput: Map<Racer, Power>) {
    val tracks: List<Track>
        get() = racingInput.map { Track(it.key, it.value) }
}
