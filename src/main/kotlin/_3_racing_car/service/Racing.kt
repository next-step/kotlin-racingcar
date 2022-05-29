package _3_racing_car.service

import _3_racing_car.service.dto.RacingInputDto
import _3_racing_car.service.dto.RacingOutputDto

class Racing(private val racingInput: RacingInputDto) {
    fun start(times: Int): RacingOutputDto {
        val racerResults: Map<String, Int> = racingInput.tracks.associate { track ->
            val racer = track.run(times)
            racer.name to racer.location
        }
        return RacingOutputDto(racerResults)
    }
}
