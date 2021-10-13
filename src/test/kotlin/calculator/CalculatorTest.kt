package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorTest {
    @DisplayName("예시로 나온 계산이 성공하는지 확인.")
    @ParameterizedTest
    @CsvSource("2 + 3 * 4 / 2,10", "15 - 3 / 3,4")
    fun `계산 성공`(input: String, result: Int) {
        val list = input.split(" ")
        println(
            list.subList(1, list.size)
                .zipWithNext()
        )
        assertThat(Calculator(input).calculate())
            .isEqualTo(result)
    }
}
