package src.step2

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource

class OperationTest {

    @Test
    fun `연산자가 없을때`() {
        assertThrows<IllegalArgumentException> {
            StringCalculator.execute("1234")
        }.shouldHaveMessage("연산자가 입력되지 않았습니다")
    }

    @Test
    fun `계산할 숫자가 없을때`() {
        assertThrows<IllegalArgumentException> {
            StringCalculator.execute("asd/")
        }.shouldHaveMessage("숫자가 입력되지 않았습니다")
    }

    @EmptySource
    @ParameterizedTest
    fun `값이 입력되지 않았을 때`(input: String) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.execute(input)
        }.shouldHaveMessage("값이 입력되지 않았습니다")
    }

    @ParameterizedTest
    @CsvSource("2+2,4", "2/2,1", "1+2/3-4,-3")
    fun `계산기 값이 올바르게 출력되는지`(value: String, expected: Int) {
        Assertions.assertThat(StringCalculator.execute(value)).isEqualTo(expected)
    }
}
