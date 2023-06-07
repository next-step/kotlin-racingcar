package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Number 클래스 테스트")
class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2", "10", "100", "1000", "10000"])
    fun `유효한 타입의 인자를 전달하면 정상적으로 생성된다`(input: String) {
        val intInput = input.toInt()
        val numberFromString = Number(input)
        val numberFromInt = Number(intInput)

        assertThat(numberFromString.value).isEqualTo(intInput)
        assertThat(numberFromInt.value).isEqualTo(intInput)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "a", "hansol", "-", "+", "*", "/"])
    fun `유효하지 않은 타입의 인자를 전달하면 예외를 던진다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Number(input)
        }
    }
}
