package step3.racing.rule

import kotlin.random.Random

class CarMovementRuleImpl : CarMovementRule {
    override val rule: () -> Boolean = { Random.nextInt(10) >= 4 }
}
