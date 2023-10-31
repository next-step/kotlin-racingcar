package racingcar.service

import racingcar.domain.Cars

class RacingCarService(private val carName: List<String>, val operateCount: Int) {

    fun startRacing() {
        val cars = Cars(carName)
    }
}
