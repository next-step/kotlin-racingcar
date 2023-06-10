package step3.domain.car

import kotlin.random.Random

class RandomMovePointDecider(private val moveThreshold: Int = 4, private val minRandomValue: Int = 0, private val maxRandomValue: Int = 9, private val defaultMovePoint: Int = 1) :
    CarMovePointDecider {
    override fun getMovePoint(): Int {
        if ((Random.nextInt(maxRandomValue + 1) + minRandomValue) >= moveThreshold) {
            return defaultMovePoint
        }
        return 0
    }
}
