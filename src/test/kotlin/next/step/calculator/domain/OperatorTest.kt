package next.step.calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import next.step.calculator.domain.exception.IllegalOperatorFormatException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @CsvSource(value = ["+:PLUS", "-:MINUS", "*:TIMES", "/:DIVIDE"], delimiter = ':')
    @ParameterizedTest(name = "[{index}] \"{0}\" : Operator.{1}")
    fun `사칙연산 기호로 Operator 생성`(symbol: String, expected: Operator) {
        Operator.from(symbol) shouldBe expected
    }

    @NullSource
    @ParameterizedTest
    fun `null로 Operator 생성시 예외 발생`(nullStr: String?) {
        shouldThrow<IllegalOperatorFormatException> {
            Operator.from(nullStr)
        }
    }

    @ValueSource(strings = ["", " ", "     "])
    @ParameterizedTest(name = "[{index}] \"{0}\"")
    fun `공백으로 Operator 생성시 예외 발생`(spaces: String) {
        shouldThrow<IllegalOperatorFormatException> {
            Operator.from(spaces)
        }
    }

    @ValueSource(strings = ["eng", "한글", "."])
    @ParameterizedTest(name = "[{index}] \"{0}\"")
    fun `공백이 아니고 사칙연산 기호가 아니면 Operator 생성시 예외 발생`(invalidSymbol: String) {
        shouldThrow<IllegalOperatorFormatException> {
            Operator.from(invalidSymbol)
        }
    }

    @CsvSource(value = ["PLUS:20:10:30", "MINUS:20:10:10", "TIMES:20:10:200", "DIVIDE:20:10:2"], delimiter = ':')
    @ParameterizedTest(name = "[{index}] {1} {0} {2} = {3}")
    fun `각 Operator로 사칙연산 수행`(operator: Operator, a: Int, b: Int, expected: Int) {
        operator.evaluate(InputNumber(a), InputNumber(b)) shouldBe InputNumber(expected)
    }
}
