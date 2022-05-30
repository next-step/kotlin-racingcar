package racing.domain.race

import racing.domain.common.CarRaceProperty
import racing.domain.utils.RandomNumberStrategy

class CarRace(private val carRaceProperty: CarRaceProperty) {

    fun start(randomNumberMaker: RandomNumberStrategy) {
        repeat(carRaceProperty.roundSize) { round ->
            startByRound(round, randomNumberMaker)
        }
    }

    fun startByRound(round: Int, randomNumberMaker: RandomNumberStrategy) {
        carRaceProperty.cars.forEach { it.move(round, randomNumberMaker.getRandomNumber()) }
    }
}
