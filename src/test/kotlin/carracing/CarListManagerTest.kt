package carracing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarListManagerTest : StringSpec({

    "moveCar 는 자동차를 이동시킨다" {
        // given
        val defaultDistance = 3
        val forwardDistance = 5
        val car = Car(defaultDistance)
        val carList = CarList(listOf(car))

        // when
        carList.moveCar(0, forwardDistance)

        // then
        carList.cars[0].distance shouldBe defaultDistance + forwardDistance
    }

    "getCarDistance 는 자동차 거리를 알려준다" {
        // given
        val defaultDistance = 3
        val car = Car(defaultDistance)
        val carList = CarList(listOf(car))

        // when
        val carDistance = carList.getCarDistance(0)

        // then
        carDistance shouldBe defaultDistance
    }

    "validateCarsIndex 는 설정하는 자동차의 Index 번호를 검증한다" {
        // given
        val car = Car()
        val carList = CarList(listOf(car))
        val carIndex = -1

        // when
        val shouldThrowExactly = shouldThrowExactly<IllegalArgumentException> {
            carList.validateCarsIndex(carIndex)
        }

        // then
        shouldThrowExactly.message shouldBe "음수 값으로 시스템을 실행할수 없습니다"
    }

    "validateCarsIndex 는 cars 에 사이즈를 넘긴 값을 넣으면 에러가 발생한다" {
        // given
        val car = Car()
        val carList = CarList(listOf(car))
        val carIndex = 30000

        // when
        val shouldThrowExactly = shouldThrowExactly<IllegalArgumentException> {
            carList.validateCarsIndex(carIndex)
        }

        // then
        shouldThrowExactly.message shouldBe "존재 하지 않은 번호 입니다"
    }
})
