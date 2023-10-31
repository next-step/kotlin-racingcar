package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("자동차 이름은 5자 이하만 가능합니다.") {
        val exception = shouldThrow<IllegalArgumentException> {
            Car("car1234")
        }
        exception.message shouldBe "자동차 이름은 5자 이하만 가능합니다."
    }

    test("자동차를 움직인다") {
        val car = Car("car1")
        val movedCar = car.move(generate(4, 9)) // 4 이상이면 이동
        movedCar.position shouldBe car.position + 1
    }

    test("자동차를 움직이지 않는다") {
        val car = Car("car1")
        val movedCar = car.move(generate(end = 3)) // 3 이하면 정지
        movedCar.position shouldBe car.position
    }
})
