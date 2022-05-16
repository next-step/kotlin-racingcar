package racing.domain

import kotlin.random.Random

interface PowerStrategy {
    fun getPower(): Int
}

object ZeroPowerStrategy : PowerStrategy {
    override fun getPower(): Int = 0
}

class RandomPowerStrategy(private val carMaxPower: Int = DEFAULT_MAX_POWER) : PowerStrategy {
    override fun getPower(): Int = Random.nextInt(carMaxPower)

    companion object {
        private const val DEFAULT_MAX_POWER = 10
    }
}

class StaticPowerStrategy(private val power: Int) : PowerStrategy {
    override fun getPower(): Int = power
}
