package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : FunSpec({
    test("move 함수를 호출해, 연료 값들을 가지고 자동차들을 움직이게 시도할 수 있다.") {
        // given
        val cars = Cars(listOf(Car(name = CarName.of("charlie")), Car(name = CarName.of("brown"))))

        // when
        val resultCars = cars.moveForwardAll(listOf(4, 3))

        // then
        resultCars.value[0].distanceMoved shouldBe 1
        resultCars.value[1].distanceMoved shouldBe 0
    }

    test("자동차 이름값들의 정보를 받아서, 참가자 수만큼 자동차 객체를 생성한다.") {
        // given
        val carNames = CarNames.of("charlie,brown,snoopy,dog")

        // when
        val cars = Cars.initCars(carNames = carNames)

        // then
        cars.value.size shouldBe 4
    }
})
