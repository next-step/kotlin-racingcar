package step4.model

import kotlin.random.Random

data class Race(val names: String) {
    private val cars = getCars(names)

    private fun getCars(names: String): MutableList<Car> {
        val carNames = names.split(CAR_NAME_DELIMITER)
        val carList = ArrayList<Car>()

        for (carName in carNames) {
            carList.add(Car(carName, 0, mutableListOf()))
        }
        return carList
    }

    fun makeTurn() {
        for (car in cars) {
            val resultOfTurn = successToMove(getRandomNumber())
            car.saveResult(resultOfTurn)
        }
    }

    fun getCars(): List<Car> {
        return cars
    }

    private fun successToMove(random: Int): Int {
        return if (random >= MIN_VALUE_TO_MOVE) SUCCESS_TO_MOVE else FAIL_TO_MOVE
    }

    private fun getRandomNumber(): Int {
        return Random.nextInt(10)
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
        private const val MIN_VALUE_TO_MOVE = 4

        private const val SUCCESS_TO_MOVE = 1
        private const val FAIL_TO_MOVE = 0
    }
}
