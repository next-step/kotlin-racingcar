package racingCar.domain

import java.util.Random

class RandomStrategy:MoveStrategy {

    private val random: Random = Random()

    override fun move(): Boolean = random.nextInt(10)  >= 4
}
