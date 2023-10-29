package racing

import kotlin.random.Random

class Car {
    private var position = 0
    fun moveForward(randomValue: () -> Int = { Random.nextInt(10) }) {
        val forwardSteps = randomValue()
        if (forwardSteps >= 4) {
            position += 1
        }
    }
}
