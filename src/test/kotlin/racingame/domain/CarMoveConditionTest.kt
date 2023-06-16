package racingame.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingame.fake.FakeNumberGenerator

class CarMoveConditionTest : FunSpec({

    test("4 이상의 수가 제공될 경우 isMovable 은 true 를 반환한다.") {
        // given
        val numberGenerator = FakeNumberGenerator(4)
        val carMoveCondition = CarMoveCondition(numberGenerator)

        // when, then
        carMoveCondition.isMovable() shouldBe true
    }

    test("4 미만의 수가 제공될 경우 isMovable 은 false 를 반환한다.") {
        // given
        val numberGenerator = FakeNumberGenerator(2)
        val carMoveCondition = CarMoveCondition(numberGenerator)

        // when, then
        carMoveCondition.isMovable() shouldBe false
    }
})
