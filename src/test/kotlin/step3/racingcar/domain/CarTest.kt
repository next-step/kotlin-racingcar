package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    given("경주에 참가하는 자동차 한대에 4이상의 숫자가 주어지고") {
        val givenCar = Car("참가 차량")

        `when`("경주를 진행하면") {
            givenCar.race(4)
            then("현재 차량의 주행거리를 1만큼 누적한다.") {
                givenCar.distance shouldBe 1
            }
        }
    }

    given("경주에 참가하는 자동차 한대에 3이하의 숫자가 주어지고") {
        val givenCar = Car("참가 차량")

        `when`("경주를 진행하면") {
            givenCar.race(3)
            then("현재 차량의 주행거리는 누적되지 않는다.") {
                givenCar.distance shouldBe 0
            }
        }
    }

    given("경주에 참가하는 자동차 한대가 주어지고") {
        val car = Car("참가 차량")

        `when`("첫번째 라운드에 4가 주어지면") {
            car.race(4)
            then("차량 전진 횟수가 1 증가한다.") {
                car.distance shouldBe 1
            }
        }
        `when`("두번째 라운드에 3이 주어지면") {
            car.race(3)
            then("차량의 전진 횟수는 증가하지 않는다.") {
                car.distance shouldBe 1
            }
        }
        `when`("세번째 라운드에 6이 주어지면") {
            car.race(6)
            then("차량 전진 횟수가 1 증가한다.") {
                car.distance shouldBe 2
            }
        }
    }
})
