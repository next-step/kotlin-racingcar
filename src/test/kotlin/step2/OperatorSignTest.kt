package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class OperatorSignTest : FunSpec({
    context("getBySign 메서드는") {
        context("올바른 연산 기호를 입력하면") {
            test("연산 기호에 해당하는 OperatorSign 을 반환한다.") {
                listOf(
                    Pair("+", OperatorSign.PLUS),
                    Pair("-", OperatorSign.MINUS),
                    Pair("x", OperatorSign.MULTIPLE),
                    Pair("/", OperatorSign.DIVIDE),
                ).forEach {
                    val (given: String, expected: OperatorSign) = it
                    val actual = OperatorSign.getBySign(sign = given)
                    actual shouldBe expected
                }
            }
        }

        context("잘못된 연산 기호를 입력하면") {
            test("IllegalArgumentException 이 발생한다.") {
                val exception = assertThrows<IllegalArgumentException> { OperatorSign.getBySign(sign = "*") }
                exception.message shouldBe "잘못된 연산 기호를 입력했습니다."
            }
        }
    }
})
