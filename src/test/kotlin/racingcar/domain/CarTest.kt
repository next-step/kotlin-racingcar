package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeExactly

class CarTest : DescribeSpec({
    describe("자동차 이동 테스트") {
        it("입력된 숫자가 4 이상이면 이동한다.") {
            val randomNumber = 4
            val car = Car()

            car.move(randomNumber)
            car.position shouldBeExactly 1
        }

        it("입력된 숫자가 4 미만이면 멈춰있는다.") {
            val randomNumber = 3
            val car = Car()

            car.move(randomNumber)
            car.position shouldBeExactly 0
        }
    }
})
