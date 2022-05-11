package racing

import kotlin.random.Random

interface PowerStrategy {
    fun getPower(): Int
}

object ZeroPowerStrategy : PowerStrategy {
    override fun getPower(): Int = 0
}

class RandomPowerStrategy(private val carMaxPower: Int) : PowerStrategy {
    override fun getPower(): Int = Random.nextInt(carMaxPower)
}

class StaticPowerStrategy(private val power: Int) : PowerStrategy {
    override fun getPower(): Int = power
}