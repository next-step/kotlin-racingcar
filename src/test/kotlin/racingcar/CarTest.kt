package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("자동차를 움직인다") {
        val car = Car("car1")
        val movedCar = car.move(generate(4,9)) // 4 이상이면 이동
        movedCar.position shouldBe movedCar.position + 1
    }

    test("자동차를 움직이지 않는다") {
        val car = Car("car1")
        val movedCar = car.move(generate(end = 3)) // 3 이하면 정지
        movedCar.position shouldBe movedCar.position
    }

})
