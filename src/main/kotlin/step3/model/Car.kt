package step3.model

import step3.util.RandomGenerator

class Car(val id: Int) {

    fun move(): Boolean {
        val minRandomValue = 0
        val maxRandomValue = 9
        val moveWhenAbove = 4

        val randomValue = RandomGenerator.generate(minRandomValue, maxRandomValue)
        return randomValue >= moveWhenAbove
    }
}
