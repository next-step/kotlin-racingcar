package racingcar.model.movement

import kotlin.random.Random
import kotlin.random.nextInt

class DefaultMovement : Movement {
    override fun canMoveNow() = Random.nextInt(0..9) >= 4
}
