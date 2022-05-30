package racing.domain.race

import racing.domain.common.CarRaceProperty
import racing.domain.utils.RandomNumberStrategy

class CarRace(private val carRaceProperty: CarRaceProperty) {
    fun startByRound(randomNumberMaker: RandomNumberStrategy) {
        repeat(carRaceProperty.roundSize) { round ->
            carRaceProperty.cars.forEach { it.move(round, randomNumberMaker.getRandomNumber()) }
        }
    }
}
