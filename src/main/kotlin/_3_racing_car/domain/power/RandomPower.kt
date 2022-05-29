package _3_racing_car.domain.power

import kotlin.random.Random

class RandomPower(private val min: Int, private val max: Int) : Power {
    override fun create() = Random.nextInt(min, max)
}
