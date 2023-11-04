package study

import kotlin.random.Random

class CarRace(
    private val cars: MutableMap<String, ArrayList<String>> = mutableMapOf(),
) {

    private fun initCars(carQuantity: Int) {
        for (quantity in 1..carQuantity) {
            this.cars["차$quantity"] = ArrayList()
        }
    }

    private fun moveOrStop(): String? = if (Random.nextInt(10) >= 4) "-" else null

    private fun setCars(carQuantity: Int) {
        for (quantity in 1..carQuantity) {
            val carStatus = moveOrStop()

            carStatus?.let {
                cars["차$quantity"]?.add(it)
            }

            val result = cars["차$quantity"]?.joinToString("")
            println("차$quantity >> $result")
        }
    }

    fun setInning(inningCount: Int, carQuantity: Int) {
        for (count in 1..inningCount) {
            println("$count 회")
            setCars(carQuantity)
        }
    }

    private fun input1(): Int {
        print("자동차 대수는 몇 대인가요? ")
        val number = readlnOrNull()
        println(number)

        if (number.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        return number.toInt()
    }

    private fun input2(): Int {
        print("시도할 횟수는 몇 회인가요? ")
        val number = readlnOrNull()
        println(number)

        if (number.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        return number.toInt()
    }

    fun start() {
        val carQuantity = input1()
        val inningCount = input2()

        initCars(carQuantity)
        setInning(inningCount, carQuantity)
    }
}
