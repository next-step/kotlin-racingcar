package step3.racing.rule

import kotlin.random.Random

class CarRandomMovementRule : CarMovementRule {
    override val rule: () -> Boolean = { Random.nextInt(10) >= 4 }
}
