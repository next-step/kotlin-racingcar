package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : FunSpec({
    test("move 함수를 호출해, 연료 값들을 가지고 자동차들을 움직이게 시도할 수 있다.") {
        // given
        val cars = Cars(listOf(Car(), Car()))

        // when
        val resultCars = cars.move(listOf(4, 3))

        // then
        resultCars.values[0].distanceMoved shouldBe 1
        resultCars.values[1].distanceMoved shouldBe 0
    }

    test("initCars 정적 팩터리를 호출해, 참여자 수만큼 자동차 객체를 생성한다.") {
        // given
        val numberOfParticipants = 4

        // when
        val cars = Cars.initCars(numberOfParticipants)

        // then
        cars.values.size shouldBe 4
    }
})
