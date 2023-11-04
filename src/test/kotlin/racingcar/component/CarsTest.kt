package racingcar.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.model.Car

class CarsTest : FunSpec({
    test("1회 자동차를 이동시켰을 때 1만큼 자동차의 거리가 증가했는지 테스트") {
        val round = 1
        val car = Car("dummy")
        val cars = Cars(listOf(car))

        repeat(round) {
            cars.moveCars { true }
        }

        car.getDistance() shouldBe 1
    }

    test("우승자가 다수일 경우 정확한 우승자 수를 반환하는지 테스트") {
        val winners = listOf(
            Car("dummy1"),
            Car("dummy2")
        )
        val cars = Cars(winners)

        val result = cars.getWinners()

        result.size shouldBe 2
    }
})
