package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({

    given("자동차 이름 정보를 받는다.") {
        var carNames = "car1,car2,car3".split(",")
        `when`("입력 받은 정보로 자동차를 생성한다.") {
            val cars = Cars(carNames)
            then("생성된 자동차 갯수를 확인한다.") {
                cars.carList.size shouldBe carNames.size
            }
        }
        carNames = "car12, car123, car1234".split(",")
        `when`("자동차 이름이 5자 이상이면 예외를 발생시킨다.") {
            val exception = shouldThrow<IllegalArgumentException> {
                Cars(carNames)
            }
            then("예외가 발생한다.") {
                exception.message shouldBe "자동차 이름은 5자 이하만 가능합니다."
            }
        }
    }

    given("자동차들을 움직인다.") {
        val carNames = "car1,car2,car3".split(",")
        val cars = Cars(carNames)
        `when`("자동차들을 조작한다.") {
            cars.operateCars()
            then("자동차들이 움직이거나 멈췄다.") {
                cars.carList.forEach { car ->
                    (0..1).contains(car.position) shouldBe true
                }
            }
        }

        `when`("우승자를 구한다.") {
            val winners = cars.isWinner()
            then("우승자가 존재한다.") {
                winners.size shouldBeGreaterThanOrEqual 1
            }
        }
    }
})
