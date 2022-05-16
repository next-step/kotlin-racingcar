package racing.car

import racing.common.CarRaceProperty

class CarRegistration(private val roundSize: Int, private val carNames: List<String>) {

    fun initCarRaceProperty(): CarRaceProperty {

        return CarRaceProperty(
            roundSize = roundSize,
            cars = carNames.map { Car(it, INIT_MOVE) }
        )
    }

    companion object {
        private const val INIT_MOVE = 0
    }
}
