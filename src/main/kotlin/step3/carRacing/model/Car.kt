package step3.carRacing

import kotlin.random.Random

class CarGenerator {
    companion object {
        fun generate(size: Int) = List<Car>(size) { Car() }
    }
}

class Car {
    var curPosition = 0

    fun tryRace() {
        val randomNumber = Random.nextInt(0, 10)

        if (randomNumber in 4 until 10) { // NOTE: 4 이상 일 경우 이동
            curPosition++
        }
    }
}
