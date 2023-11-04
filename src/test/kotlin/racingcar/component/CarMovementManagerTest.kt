package racingcar.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.model.Car

class CarMovementManagerTest : FunSpec({
    test("1회 자동차를 이동시켰을 때 1만큼 자동차의 거리가 증가했는지 테스트") {
        val carMovementManager = CarMovementManager { true }
        val round = 1
        val car = Car("dummy")
        val cars = Cars(listOf(car))

        repeat(round) {
            carMovementManager.moveCarsWithCondition(cars)
        }

        car.getDistance() shouldBe 1
    }
})
