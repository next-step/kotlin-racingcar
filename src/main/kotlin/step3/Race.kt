package step3

import java.util.Random

object Race {
    private const val FIXED_BOUND = 10
    private val randomGenerator = Random()
    private fun getRandomValue(bound: Int) = randomGenerator.nextInt(bound)
    fun tryMoveCar(car: Car) {
        val randomValue = getRandomValue(FIXED_BOUND)
        if (car.isMoveAble(randomValue))
            car.move()
    }
}
