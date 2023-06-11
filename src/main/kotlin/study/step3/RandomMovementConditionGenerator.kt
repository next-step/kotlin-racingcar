package study.step3

import kotlin.random.Random

class RandomMovementConditionGenerator : MovementConditionGenerator {
    override fun run(): Int {
        return Random.nextInt(0, 10)
    }
}
