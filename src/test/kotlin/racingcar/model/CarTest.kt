package racingcar.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    test("1회 자동차를 이동시켰을 때 1만큼 자동차의 거리가 증가했는지 테스트") {
        val car = Car("dummy")

        car.move()

        car.getDistance() shouldBe 1
    }
})
