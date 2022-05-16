package racing.common

import racing.car.Car

class CarRaceProperty(val roundSize: Int, val cars: List<Car>) {

    companion object {
        const val ROUND_START = 1
    }
}
