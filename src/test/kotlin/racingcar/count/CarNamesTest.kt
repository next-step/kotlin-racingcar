package racingcar.count

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarNamesTest {
    @ParameterizedTest
    @CsvSource("a, b, c")
    fun `입력된 문자열로부터 이름 리스트를 얻을 수 있다`(s1: String, s2: String, s3: String) {
        val text = "$s1,$s2,$s3"
        val expected = listOf(s1, s2, s3)
        Assertions.assertThat(CarNames(text).value).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("a, b, c")
    fun `최소조건 미만의 이름이 입력되었을 경우 입력되었을 경우 에러처리`(s1: String, s2: String, s3: String) {
        val text = "$s1,$s2,$s3"
        Assertions.assertThatThrownBy { CarNames(text, 5) }
    }
}
