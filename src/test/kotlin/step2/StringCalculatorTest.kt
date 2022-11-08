package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class StringCalculatorTest : FunSpec({
    val tokenCalculator = ChunkTokenCalculator()
    val sut = StringCalculator(tokenCalculator = tokenCalculator)

    context("calculate 메서드는") {
        context("계산식을 문자열로 입력하면") {
            test("계산한 결과를 숫자로 반환한다.") {
                // given
                val expression = "2 + 3 x 4 / 2"
                // when
                val actual = sut.calculate(expression = expression)
                // then
                actual shouldBe 10
            }
        }

        context("null 로 입력하면") {
            test("IllegalArgumentException 이 발생한다.") {
                // given
                val expression = null
                // when
                val exception = assertThrows<IllegalArgumentException> {
                    sut.calculate(expression = expression)
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
                        sut.calculate(expression = it)
                    }
                    exception.message shouldBe "입력한 계산식은 null 또는 공백이 될 수 없습니다."
                }
            }
        }
    }
})
