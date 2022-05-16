package racing.car

import racing.common.CarRaceProperty

class CarRegistration(private val roundSize: Int, private val carSize: Int) {

    fun initCarRaceProperty(): CarRaceProperty {
        val cars = mutableListOf<Car>()
        repeat(carSize) {
            cars.add(Car(INIT_MOVE))
        }

        return CarRaceProperty(roundSize, carSize, cars)
    }

    companion object {
        private const val INIT_MOVE = 0
    }
}
