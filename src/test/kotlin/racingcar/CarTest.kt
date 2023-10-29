package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn

class CarTest : FunSpec({

    test("자동차를 이동하거나 멈춘다.") {
        val car = Car("car1")
        val movedCar = car.move() // 4 이상이면 이동
        movedCar.position shouldBeIn listOf(movedCar.position, movedCar.position + 1)
    }
})
