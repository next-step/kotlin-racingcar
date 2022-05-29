package _3_racing_car.service

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Racer
import _3_racing_car.service.dto.RacerDto

class Track(private val racer: Racer, private val power: Power) {
    fun run(times: Int): RacerDto {
        val location = List(times) { racer.move(power.create()).value }.reduce { acc, i -> acc + i }
        return RacerDto(racer.name.value, location)
    }
}
