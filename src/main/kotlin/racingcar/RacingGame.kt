package racingcar

import kotlin.random.Random

class RacingGame {
    lateinit var carList: List<Car>
        private set
    lateinit var randomNumberList: Array<IntArray>
        private set
    private var times: Int = 0

    fun set(numberOfCars: Int, count: Int) {
        val carMList: MutableList<Car> = mutableListOf()
        for (i in 1..numberOfCars) {
            carMList.add(Car())
        }
        carList = carMList.toList()
        randomNumberList = Array(count) { IntArray(numberOfCars) }
    }

    fun run() {
        for (i in carList.indices) {
            val randomNumber = random()
            carList[i].move(randomNumber)
            randomNumberList[times][i] = randomNumber
        }
        times++
    }

    private fun random(): Int {
        return Random.nextInt(MAX_RANDOM_NUMBER)
    }

    companion object {
        private const val MAX_RANDOM_NUMBER: Int = 9
    }
}
