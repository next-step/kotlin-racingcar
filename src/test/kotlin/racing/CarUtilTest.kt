package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.presentation.InputView

class CarUtilTest {

    @ParameterizedTest
    @CsvSource("A , false")
    fun `문자가 입력된 경우 validate시 false 리턴`(string: String, expected: Boolean) {
        assertThat(InputView().validateAttempt(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["k3, sonata > false"],
        delimiterString = ">"
    )
    fun `자동차 이름이 5자를 초과하는 경우 validate 시 false 리턴`(string: String, expected: Boolean) {
        assertThat(InputView().validateNames(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [", , , , > false"],
        delimiterString = ">"
    )
    fun `, , , 와 같은 자동차 이름이 입력된 경우, validate 시 false 리턴`(string: String, expected: Boolean) {
        assertThat(InputView().validateNames(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["k3, k5,  , > 2"],
        delimiterString = ">"
    )
    fun `자동차 이름에 "k3, k5, , "와 같이 , 로 구분된 빈공백이 있는 경우, 2개의 name만 인정되는지 확인`(string: String, expected: Int) {
        assertThat(InputView().splitNames(string).size).isEqualTo(expected)
    }
}
