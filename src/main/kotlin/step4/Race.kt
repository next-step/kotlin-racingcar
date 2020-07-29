package step4

import kotlin.random.Random

object Race {
    private const val CAR_NAME_DELIMITER = ","
    private const val MIN_VALUE_TO_MOVE = 4

    private const val SUCCESS_TO_MOVE = 1
    private const val FAIL_TO_MOVE = 0

    fun initiate(carNameList: String): List<Car> {
        val carNames = carNameList.split(CAR_NAME_DELIMITER)
        val carList = ArrayList<Car>()

        for (carName in carNames) {
            carList.add(Car(carName, 0, mutableListOf()))
        }
        return carList
    }

    fun makeTurn(cars: List<Car>): List<Car> {
        for (car in cars) {
            val resultOfTurn = successToMove(getRandomNumber())

            car.saveResult(resultOfTurn)
        }
        return cars
    }

    private fun successToMove(random: Int): Int {
        return if (random >= MIN_VALUE_TO_MOVE) SUCCESS_TO_MOVE else FAIL_TO_MOVE
    }

    fun getRandomNumber(): Int {
        return Random.nextInt(10)
    }
}
