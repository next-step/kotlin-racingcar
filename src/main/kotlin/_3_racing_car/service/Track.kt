package _3_racing_car.service

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Racer
import _3_racing_car.service.dto.RacerDto

class Track(val racer: Racer, private val power: Power) {
    fun run(times: Int): RacerDto {
        repeat(times) {
            racer.move(power.create(from = 0, until = 9))
        }
        return RacerDto(racer.name, racer.location)
    }
}
