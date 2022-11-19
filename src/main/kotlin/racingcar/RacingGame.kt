package racingcar

import kotlin.random.Random

class RacingGame {
    lateinit var carList: List<Car>
        private set

    fun set(numberOfCars: Int, count: Int) {
        val carMList: MutableList<Car> = mutableListOf()
        for (i in 1..numberOfCars) {
            carMList.add(Car())
        }
        carList = carMList.toList()
    }

    private fun random(): Int {
        return Random.nextInt(MAX_RANDOM_NUMBER)
    }

    companion object {
        private const val MAX_RANDOM_NUMBER: Int = 9
    }
}
