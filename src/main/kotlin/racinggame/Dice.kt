package racinggame

import kotlin.random.Random

interface Dice {
    fun pitch(): Int
}

class RandomDice : Dice {
    override fun pitch() = Random.nextInt() % 10
}

class ForwardDice : Dice {
    override fun pitch() = 4
}