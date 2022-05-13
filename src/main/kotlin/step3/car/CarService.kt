package step3.car

import step3.common.CarRaceProperty

class CarService(private val carRaceProperty: CarRaceProperty) {

    fun initCars() {
        for (carIndex in 0 until carRaceProperty.carSize) {
            carRaceProperty.cars.add(Car(INIT_MOVE))
        }
    }

    companion object {
        private const val INIT_MOVE = 0
    }
}
