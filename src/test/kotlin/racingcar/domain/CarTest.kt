package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeExactly

class CarTest : DescribeSpec({
    describe("자동차 이동 테스트") {
        it("이름이 5자를 초과하면 IllegalArgument 예외가 throw 된다.") {
            shouldThrow<IllegalArgumentException> {
                Car("ppororo")
            }
        }

        it("입력된 숫자가 4 이상이면 이동한다.") {
            val randomNumber = 4
            val car = Car("pobi")

            car.move(randomNumber)
            car.position shouldBeExactly 1
        }

        it("입력된 숫자가 4 미만이면 멈춰있는다.") {
            val randomNumber = 3
            val car = Car("pobi")

            car.move(randomNumber)
            car.position shouldBeExactly 0
        }
    }
})
