package study.racingcar

class Car(val name: String) {

    var distance: Int = 0
        private set

    fun moveCar() {
        distance++
    }

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5

        fun newCar(carName: String): Car {
            if (isExcessCarNameLength(carName)) {
                throw IllegalArgumentException("$carName is excess $MAX_CAR_NAME_LENGTH")
            }

            return Car(carName)
        }

        private fun isExcessCarNameLength(carName: String): Boolean {
            return carName.length > MAX_CAR_NAME_LENGTH
        }
    }
}
