package racing.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CarTest : DescribeSpec({

    describe("자동차 생성") {
        it("생성 위치가 음수인 경우 IllegalArgumentException 이 발생한다.") {
            // given
            val invalidPosition = -1

            // when
            val car = shouldThrow<IllegalArgumentException> {
                Car(invalidPosition)
            }

            // then
            car.message shouldBe Car.INVALID_POSITION_EXCEPTION
        }
    }

    describe("자동차 이동") {
        it("무작위 값이 3 이하일 경우 정지한다.") {
            // given
            val randomValue = 3
            val car = Car(0)

            // when
            val movedCar = car.moveForward(randomValue)

            // then
            movedCar.compareTo(Car(0)) shouldBe 0
        }

        it("무작위 값이 4 이상일 경우 전진한다.") {
            // given
            val randomValue = 4
            val car = Car(0)

            // when
            val movedCar = car.moveForward(randomValue)

            // then
            movedCar.compareTo(Car(1)) shouldBe 0
        }
    }

    describe("자동차 출력") {
        it("현재 위치 만큼 -로 표현된다.") {
            // given
            val position = 5
            val movedCar = Car(position)

            // when
            val result = movedCar.toString()

            // then
            result shouldBe "unknown: -----"
        }

        it("현재 위치가 0일 경우 공백으로 표현한다.") {
            // given
            val position = 0
            val movedCar = Car(position)

            // when
            val result = movedCar.toString()

            // then
            result shouldBe "unknown: "
        }

        it("자동차는 이름과 위치로 표현된다.") {
            // given
            val position = 5
            val name = "yohan"
            val car = Car(position, name)

            // when
            val result = car.toString()

            // then
            result shouldBe "yohan: -----"
        }
    }
})
