package study.racing.movement.condition

import kotlin.random.Random

class DefaultMovementCondition : MovementCondition {
    override fun drive(): Int {
        val num = Random.nextInt(0, 10)
        if (num >= 4) {
            return 1
        }
        return 0
    }
}
