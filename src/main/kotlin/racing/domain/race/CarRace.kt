package racing.domain.race

import racing.domain.common.CarRaceProperty
import racing.domain.utils.RandomNumberStrategy

class CarRace(private val carRaceProperty: CarRaceProperty) {

    fun start(randomNumberMaker: RandomNumberStrategy) {
        repeat(carRaceProperty.roundSize) {
            startByRound(randomNumberMaker)
        }
    }

    private fun startByRound(randomNumberMaker: RandomNumberStrategy) {
        carRaceProperty.cars.forEach { it.move(randomNumberMaker.getRandomNumber()) }
    }
}
