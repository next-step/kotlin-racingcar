package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeExactly
import racingcar.domain.strategy.CanMovableStrategyMock
import racingcar.domain.strategy.CanNotMovableStrategyMock

class CarTest : DescribeSpec({
    describe("자동차 테스트") {
        it("이름이 5자를 초과하면 IllegalArgument 예외가 throw 된다.") {
            shouldThrow<IllegalArgumentException> {
                Car("ppororo")
            }
        }

        it("전진 조건을 만족하면 이동한다.") {
            val car = Car("pobi")

            car.move(CanMovableStrategyMock())
            car.position shouldBeExactly 1
        }

        it("입력된 숫자가 4 미만이면 멈춰있는다.") {
            val car = Car("pobi")

            car.move(CanNotMovableStrategyMock())
            car.position shouldBeExactly 0
        }
    }
})
