package step3.racingcar.service

import step3.racingcar.domain.Cars
import step3.racingcar.utils.RandomNumberGenerator

class RacingCarService {
    fun play(carCount: Int, roundCount: Int): Cars {
        val cars = Cars(carCount)

        for (i in 1..roundCount) {
            playEachRound(i, cars)
        }
        return cars
    }

    private fun playEachRound(currentRound: Int, cars: Cars) {
        cars.elements().forEach {
            val randomValue = RandomNumberGenerator.generate()
            it.race(currentRound, randomValue)
        }
    }
}
