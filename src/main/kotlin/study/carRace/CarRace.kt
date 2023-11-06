package study.carRace

import kotlin.random.Random

class CarRace(
    private val cars: MutableMap<String, ArrayList<String>> = mutableMapOf(),
) {
    private val resultView = ResultView()

    fun initCars(carQuantity: Int) {
        for (quantity in 1..carQuantity) {
            this.cars["차$quantity"] = ArrayList()
        }
    }

    fun setCars() {
        for (car in cars.entries) {
            val number = Random.nextInt(10)
            val carStatus = resultView.moveOrStop(number)

            carStatus?.let { car.value.add(it) }

            val result = car.value.joinToString("")
            println("${car.key} >> $result")
        }
    }

    fun setInning(inningCount: Int) {
        for (count in 1..inningCount) {
            println("$count 회")
            setCars()
        }
    }

    fun getCars(): MutableMap<String, ArrayList<String>> {
        return this.cars
    }

    fun start(carQuantity: Int, inningCount: Int) {
        initCars(carQuantity)

        setInning(inningCount)
    }
}

class InputView {
    fun carQuantity(): Int {
        print("자동차 대수는 몇 대인가요? ")
        val quantity = readlnOrNull()
        println(quantity)

        if (quantity == "0") {
            throw IllegalArgumentException()
        }
        return quantity!!.toInt()
    }

    fun inningCount(): Int {
        print("시도할 횟수는 몇 회인가요? ")
        val count = readlnOrNull()
        println(count)

        if (count == "0") {
            throw IllegalArgumentException()
        }
        return count!!.toInt()
    }
}

class ResultView {
    fun moveOrStop(number: Int): String? = if (number >= 4) "-" else null
}
