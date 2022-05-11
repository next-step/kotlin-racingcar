package step3.car

import step3.CarRaceConst

class CarService {

    fun initCars() {
        for (carIndex in 1..5) {
            CarRaceConst.car[carIndex] = Car(carIndex, INIT_MOVE)
        }
    }

    companion object {
        private const val INIT_MOVE = 0
    }
}
