package step3.car

import step3.common.CarRaceProperty

class CarService(private val carRaceProperty: CarRaceProperty) {

    fun initCars() {
        for (carIndex in 1..carRaceProperty.carSize) {
            carRaceProperty.car[carIndex] = Car(carIndex, INIT_MOVE)
        }
    }

    companion object {
        private const val INIT_MOVE = 0
    }
}
