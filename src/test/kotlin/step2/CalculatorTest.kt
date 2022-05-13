package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @DisplayName("1) 오류없이 테스트 성공")
    @ParameterizedTest
    @CsvSource("5 + 2, 7",
               "5 - 2, 3",
               "5 * 2, 10",
               "5 / 2, 2",
               "2 + 3 * 4 / 2, 10")
    fun success (input: String, result: Int){
        val calculator = Calculator()
        Assertions.assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @DisplayName("2) 입력값이 null 또는 빈 공백 문자일 경우 테스트 실패")
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun failedInputNullOrEmpty (input: String){
        val calculator = Calculator()
        Assertions.assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("잘못된 입력값입니다.")
    }

    @DisplayName("3) 0으로 나누는 경우 테스트 실패")
    @ParameterizedTest
    @CsvSource(
        "5 / 0, 2",
        "2 + 3 * 4 / 0, 10")
    fun failedInput0 (input: String, result: Int){
        val calculator = Calculator()
        Assertions.assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("숫자를 0으로 나눌 순 없습니다.")
    }
}
