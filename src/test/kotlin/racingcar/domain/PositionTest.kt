package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

internal class PositionTest : FunSpec({

    context("객체 생성") {
        test("0 값을 가진 객체가 생성된다.") {
            Position() shouldBe Position(0)
        }

        test("0 이상의 자연수 일 경우, 객체가 생성된다.") {
            shouldNotThrowAny {
                Position(0)
            }
        }

        test("음수일 경우, IllegalArgumentException 예외가 발생한다.") {
            val exception = shouldThrow<IllegalArgumentException> {
                Position(-1)
            }
            exception.message should startWith("The minimum value for position should be greater than")
        }
    }
    context("moveForward()") {
        test("1칸 이동한다.") {
            val position = Position(0)
            val movedPosition = position.moveForward(moveStrategy = { true })

            movedPosition shouldBe Position(1)
        }

        test("1칸 이동하지 않는다.") {
            val position = Position(0)
            val movedPosition = position.moveForward(moveStrategy = { false })

            movedPosition shouldBe Position(0)
        }
    }
})
