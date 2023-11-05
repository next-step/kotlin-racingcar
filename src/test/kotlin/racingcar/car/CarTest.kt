package racingcar.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe

class CarTest: FunSpec({
    context("자동차의 초기 위치는 0이다.") {
        val car = RacingCar()
        car.position shouldBe 0
    }

    context("한번 움직인 자동차의 위치는 0 아니면 1이어야 한다.") {
        val car = RacingCar().run()
        car.position shouldBeIn listOf<Int>(0, 1)
    }
})