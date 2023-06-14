package study.racing.movement.condition

import kotlin.random.Random

class RandomMovementConditionGenerator : MovementConditionGenerator {
    override fun execute(): Int {
        return Random.nextInt(0, 10)
    }
}
