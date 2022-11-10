package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class ExpressionValidatorTest : FunSpec({
    val sut = ExpressionValidator

    context("validate 메서드는") {
        context("올바른 계산식을 입력하면") {
            test("유효성 검사를 마친 계산식을 다시 반환한다.") {
                // given
                val expression = "2 + 3"
                // when
                val actual = sut.validate(expression = expression)
                actual shouldBe expression
            }
        }

        context("null 로 입력하면") {
            test("IllegalArgumentException 이 발생한다.") {
                // given
                val expression = null
                // when
                val exception = assertThrows<IllegalArgumentException> {
                    sut.validate(expression = expression)
                }
                // then
                exception.message shouldBe "입력한 계산식은 null 또는 공백이 될 수 없습니다."
            }
        }

        context("빈 공백 문자로 입력하면") {
            test("IllegalArgumentException 이 발생한다.") {
                // given
                val blanks = listOf("", " ", "  ")
                // when & then
                blanks.forEach {
                    val exception = assertThrows<IllegalArgumentException> {
                        sut.validate(expression = it)
                    }
                    exception.message shouldBe "입력한 계산식은 null 또는 공백이 될 수 없습니다."
                }
            }
        }
    }
})
