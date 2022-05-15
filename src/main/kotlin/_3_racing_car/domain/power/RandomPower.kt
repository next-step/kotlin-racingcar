package _3_racing_car.domain.power

import kotlin.random.Random

class RandomPower : Power {
    override fun create(from: Int, until: Int) = Random.nextInt(from, until)
}
