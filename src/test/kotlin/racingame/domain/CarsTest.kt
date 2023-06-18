package racingame.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingame.fake.FakeNumberGenerator
import racingame.fixture.CarFixture.NAME_RED

class CarsTest : FunSpec({

    test("cars 에 속한 car 들을 움직일 수 있다.") {
        // given
        val moveCondition = CarMoveCondition(FakeNumberGenerator(5))
        val cars = listOf(Car(name = NAME_RED, moveCondition = moveCondition))
        val nextPosition = Car.DEFAULT_POSITION + 1

        // when
        Cars(cars).race()

        // then
        cars.forEach {
            it.position shouldBe nextPosition
        }
    }
})
