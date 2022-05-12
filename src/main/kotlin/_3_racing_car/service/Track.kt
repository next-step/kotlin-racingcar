package _3_racing_car.service

import _3_racing_car.domain.power.Power
import _3_racing_car.domain.racer.Racer

class Track(private val racer: Racer, private val power: Power) {
    fun run(times: Int): Int {
        repeat(times) {
            racer.move(power.create())
        }
        return racer.location
    }
}
