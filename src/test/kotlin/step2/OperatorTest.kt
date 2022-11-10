package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class OperatorTest : FunSpec({
    val sut = Operator
    context("getByLabel 함수는") {
        context("올바른 연산 기호를 입력하면") {
            test("연산 기호에 해당하는 Operator 를 반환한다.") {
                listOf(
                    Pair("+", Operator.PLUS),
                    Pair("-", Operator.MINUS),
                    Pair("*", Operator.MULTIPLE),
                    Pair("/", Operator.DIVIDE),
                ).forEach {
                    val (given: String, expected: Operator) = it
                    val actual = Operator.getByLabel(label = given)
                    actual shouldBe expected
                }
            }
        }

        context("잘못된 연산 기호를 입력하면") {
            test("IllegalArgumentException 이 발생한다.") {
                val exception = assertThrows<IllegalArgumentException> { sut.getByLabel(label = "X") }
                exception.message shouldBe "연산 기호는 +, -, *, / 만 입력할 수 있습니다."
            }
        }
    }

    context("existsByLabel 함수는") {
        context("입력한 값에 해당하는 Operator label 이 있으면") {
            test("true 를 반환한다.") {
                Operator.existsByLabel("+") shouldBe true
            }
        }

        context("입력한 값에 해당하는 Operator label 이 없으면") {
            test("false 를 반환한다.") {
                Operator.existsByLabel("!") shouldBe false
            }
        }
    }

    context("연산 테스트") {
        test("plus 연산") {
            Operator.PLUS.execute(1, 3) shouldBe 4
        }

        test("minus 연산") {
            Operator.MINUS.execute(10, 3) shouldBe 7
        }

        test("multiple 연산") {
            Operator.MULTIPLE.execute(3, 4) shouldBe 12
        }

        test("divide 연산") {
            Operator.DIVIDE.execute(12, 3) shouldBe 4
        }

        test("divide 연산은 0으로 나누면 에러가 발생한다.") {
            val exception = assertThrows<IllegalStateException> { Operator.DIVIDE.execute(12, 0) }
            exception.message shouldBe "0 으로 숫자를 나눌 수 없습니다."
        }
    }
})
