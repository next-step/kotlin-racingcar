package racingcar.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

internal class RoundTest : FunSpec({

    context("객체 생성") {
        test("0 이상의 자연수일 경우, 객체를 생성할 수 있다.") {
            shouldNotThrowAny {
                Round(0)
            }
        }

        test("음수일 경우, IllegalArgumentException 예외가 발생한다.") {
            val exception = shouldThrow<IllegalArgumentException> {
                Round(-1)
            }

            exception.message should startWith("The minimum value for round should be greater than")
        }
    }

    context("next()") {
        test("시도 횟수가 1 이상일 경우, 시도 횟수가 1 줄어든 객체를 반환한다.") {
            val actual = Round(1).next()
            actual shouldBe Round(0)
        }

        test("시도 횟수가 남지 않았을 경우, IllegalStatementException 예외가 발생한다.") {
            val exception = shouldThrow<IllegalStateException> {
                Round(0).next()
            }

            exception.message shouldBe "There is no left round"
        }
    }

    context("hasNext()") {
        test("시도 횟수가 1 이상일 경우, 참을 반환한다.") {
            val actual = Round(1).hasNext()
            actual shouldBe true
        }

        test("시도 횟수가 1 미만일 경우, 거짓을 반환한다.") {
            val actual = Round(0).hasNext()
            actual shouldBe false
        }
    }
})
