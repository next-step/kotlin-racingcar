package racing.condition

import kotlin.random.Random

class MovingCondition {

    private var randomValue = 0

    fun getRandomValue(): Int {
        randomValue = Random.nextInt(0, 10)
        return this.randomValue
    }
}
