package step3.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step3.fake.FakeNumberGenerator

class CarTest : FunSpec({
    test("전진 조건을 충족하는 car 는 전진할 수 있다.") {
        // given
        val fakeNumberGenerator = FakeNumberGenerator(5)
        val carMoveCondition = CarMoveCondition(fakeNumberGenerator)
        val carName = "song2"
        val currentPosition = 2
        val expectedPosition = 3
        val car = Car(carName, currentPosition, carMoveCondition)

        // when
        car.move()

        // then
        car.getPosition() shouldBe expectedPosition
    }

    test("전진 조건을 충족하지 않는 car 는 전진할 수 없다.") {
        // given
        val fakeNumberGenerator = FakeNumberGenerator(3)
        val carMoveCondition = CarMoveCondition(fakeNumberGenerator)
        val carName = "song2"
        val currentPosition = 2
        val expectedPosition = 2
        val car = Car(carName, currentPosition, carMoveCondition)

        // when
        car.move()

        // then
        car.getPosition() shouldBe expectedPosition
    }
})
