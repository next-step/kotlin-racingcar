package org.bmsk.racingcar.domain.model

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import org.bmsk.racingcar.domain.policy.MovementPolicy
import org.bmsk.racingcar.domain.random.RandomGenerator
import org.bmsk.racingcar.model.Position

class FakeRandomGenerator(private val value: Int) : RandomGenerator {
    override fun generate(): Int = value
}

class CarTest : WordSpec({
    "랜덤 움직임 정책" should {
        "4 이상인 경우에만 전진한다." {
            var testPosition = Position(xPos = 0)
            for (i in 0..9) {
                val randomMovementPolicy = MovementPolicy.RandomMovement(FakeRandomGenerator(i))
                val newPosition = randomMovementPolicy.move(testPosition)

                if (i >= 4) {
                    newPosition.xPos shouldBe testPosition.xPos + 1
                    testPosition = newPosition // update for next iteration
                } else {
                    newPosition.xPos shouldBe testPosition.xPos
                }
            }
        }
    }
})
