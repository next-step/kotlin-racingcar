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
})
