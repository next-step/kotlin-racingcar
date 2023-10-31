package org.bmsk.racingcar.domain.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.bmsk.racingcar.domain.policy.RandomMovementImpl
import org.bmsk.racingcar.domain.random.RandomGenerator
import org.bmsk.racingcar.model.Position

class FakeRandomGenerator(private val value: Int) : RandomGenerator {
    override fun generate(): Int = value
}

class CarTest : FunSpec({
    context("Car 클래스는") {
        context("랜덤 움직임 정책의") {
            context("랜덤으로 만들어진 수가") {
                val testPosition = Position(xPos = 0)

                test("0 .. 3인 경우에는 전진하지 않는다.") {
                    for (i in 0..3) {
                        val randomMovementPolicy = RandomMovementImpl(FakeRandomGenerator(i))
                        val newPosition = randomMovementPolicy.move(testPosition)
                        newPosition.xPos shouldBe testPosition.xPos
                    }
                }

                test("4 이상인 경우에는 전진한다.") {
                    for (i in 4..9) {
                        val randomMovementPolicy = RandomMovementImpl(FakeRandomGenerator(i))
                        val newPosition = randomMovementPolicy.move(testPosition)
                        newPosition.xPos shouldBe testPosition.xPos + 1
                    }
                }
            }
        }
    }
})
