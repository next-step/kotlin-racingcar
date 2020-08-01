package racingcar.racing.rule

import racingcar.racing.const.RANDOM_BOUND_MAX
import racingcar.racing.const.RANDOM_BOUND_MIN
import kotlin.random.Random

class CarRandomMovementRule : CarMovementRule {
    override val rule: () -> Boolean = { Random.nextInt(RANDOM_BOUND_MAX) >= RANDOM_BOUND_MIN }
}
