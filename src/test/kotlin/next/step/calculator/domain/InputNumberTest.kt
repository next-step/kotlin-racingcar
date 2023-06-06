package next.step.calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import next.step.calculator.domain.exception.IllegalInputNumberFormatException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class InputNumberTest {
    @Test
    fun `문자열로 입력 숫자 생성`() {
        InputNumber.from("123") shouldBe InputNumber(123)
    }

    @NullSource
    @ParameterizedTest
    fun `null로 입력 숫자 생성시 예외 발생`(nullStr: String?) {
        shouldThrow<IllegalInputNumberFormatException> {
            InputNumber.from(nullStr)
        }
    }

    @ValueSource(strings = ["", " ", "     "])
    @ParameterizedTest(name = "[{index}] \"{0}\"")
    fun `공백으로 입력 숫자 생성시 예외 발생`(spaces: String) {
        shouldThrow<IllegalInputNumberFormatException> {
            InputNumber.from(spaces)
        }
    }

    @ValueSource(strings = ["dfd", "한글", "+"])
    @ParameterizedTest(name = "[{index}] \"{0}\"")
    fun `공백이 아니면서 숫자가 아닌 문자열로 입력 숫자 생성시 예외 발생`(notNumber: String) {
        shouldThrow<IllegalInputNumberFormatException> {
            InputNumber.from(notNumber)
        }
    }

    @Test
    fun `입력 숫자 합`() {
        InputNumber(10).plus(InputNumber(20)) shouldBe InputNumber(30)
    }

    @Test
    fun `입력 숫자 차이`() {
        InputNumber(10).minus(InputNumber(20)) shouldBe InputNumber(-10)
    }

    @Test
    fun `입력 숫자 곱`() {
        InputNumber(10).times(InputNumber(20)) shouldBe InputNumber(200)
    }

    @Test
    fun `입력 숫자 나누기`() {
        InputNumber(20).div(InputNumber(10)) shouldBe InputNumber(2)
    }
}
