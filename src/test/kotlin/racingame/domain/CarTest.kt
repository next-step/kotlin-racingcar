package racingame.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingame.fake.FakeNumberGenerator
import java.lang.IllegalArgumentException

class CarTest : FunSpec({

    test("자동차 이름이 5자를 넘어가는 경우 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> { Car("가나다라마바사") }
    }

    test("4 이상의 값을 가지는 car 는 전진할 수 있다.") {
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
        car.position shouldBe expectedPosition
    }

    test("4 미만의 값을 가지는 car 는 전진할 수 없다.") {
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
        car.position shouldBe expectedPosition
    }
})
