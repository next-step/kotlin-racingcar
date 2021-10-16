package racingCar.model

class Cars(numberOfCars: Int) {
    private val list = List(numberOfCars) { Car() }

    fun move() {
        list.forEach {
            moveCar(it)
        }
    }

    fun mileageOfCars() = list.map { it.mileage }

    private fun moveCar(it: Car) {
        carMove().let { move ->
            if (move > 4) {
                it.forward()
            }
        }
    }

    companion object {
        fun carMove() = (0..9).random()
    }
}
