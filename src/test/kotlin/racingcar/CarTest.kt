package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("자동차를 이동시킨다.") {
        val car = Car()
        val movedCar = car.move(generate(4, 9)) // 4 이상이면 이동
        movedCar.position shouldBe car.position + 1
    }

    test("자동차가 멈춘다") {
        val car = Car()
        val stopCar = car.move(generate(0, 3)) // 4 미만이면 멈춤
        stopCar.position shouldBe car.position
    }
})
