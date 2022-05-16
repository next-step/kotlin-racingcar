package racing.car

import racing.common.CarRaceProperty

class CarRegistration(private val roundSize: Int, private val carNames: List<String>) {

    fun initCarRaceProperty(): CarRaceProperty {
        val cars = mutableListOf<Car>()
        carNames.forEach {
            cars.add(Car(it, INIT_MOVE))
        }

        return CarRaceProperty(roundSize, cars)
    }

    companion object {
        private const val INIT_MOVE = 0
    }
}
