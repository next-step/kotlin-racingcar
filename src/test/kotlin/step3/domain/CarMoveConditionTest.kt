package step3.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step3.fake.FakeNumberGenerator

class CarMoveConditionTest : FunSpec({

    test("전진 조건을 충족하는 경우 isMovable 은 true 를 반환한다.") {
        // given
        val numberGenerator = FakeNumberGenerator(4)
        val carMoveCondition = CarMoveCondition(numberGenerator)

        // when, then
        carMoveCondition.isMovable() shouldBe true
    }

    test("전진 조건을 충족하지 않는 경우 isMovable 은 false 를 반환한다.") {
        // given
        val numberGenerator = FakeNumberGenerator(2)
        val carMoveCondition = CarMoveCondition(numberGenerator)

        // when, then
        carMoveCondition.isMovable() shouldBe false
    }
})
