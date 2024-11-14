package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class ParameterizedStudyTest {
    @ParameterizedTest(name = "ValueSource를 사용하여 다양한 문자열 값을 테스트한다")
    @ValueSource(strings = ["김태현", "홍길동"])
    fun valueSourceTest(value: String) {
        println("value: $value")
        assertThat(value).isNotNull()
        assertThat(value.length).isPositive()
    }

    @ParameterizedTest(name = "NullAndEmptySource는 빈값과 null을 테스트한다")
    @NullAndEmptySource
    fun nullAndEmptySourceTest(value: String?) {
        println("value: $value")
        assertThat(value).isNullOrEmpty()
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        value = [
            "1, 2, 3",
            "2, 3, 5",
            "10, 30, 40",
        ],
    )
    fun csvSourceTest1(
        a: Int,
        b: Int,
        c: Int,
    ) {
        assertThat(a + b).isEqualTo(c)
    }

    @ParameterizedTest(name = "CsvSource null & Empty 전달한다.")
    @CsvSource(
        value = [
            ", '', 3",
        ],
    )
    fun csvSourceTest2(
        a: String?,
        b: String?,
        c: String?,
    ) {
        assertThat(a).isNull()
        assertThat(b).isEmpty()
        assertThat(c).isEqualTo("3")
    }
}
