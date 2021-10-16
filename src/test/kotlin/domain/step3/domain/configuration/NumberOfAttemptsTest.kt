package domain.step3.domain.configuration

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberOfAttemptsTest {

    @DisplayName("NumberOfAttempts 인스턴스 생성시 범위 실패 테스트")
    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(strings = ["-100", "-10", "-1"])
    fun constructor_range_fail_test(numberOfAttemptsString: String) {
        Assertions.assertThatThrownBy { NumberOfAttempts(numberOfAttemptsString) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("NumberOfAttempts 가 허용하는 범위 밖의 숫자가 입력 되었습니다.")
    }

    @DisplayName("NumberOfAttempts 인스턴스 생성시 Int 변환 실패 테스트")
    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(strings = ["일", "오", "영", "마이너스 일"])
    fun constructor_format_fail_test(numberOfAttemptsString: String) {
        Assertions.assertThatThrownBy { NumberOfAttempts(numberOfAttemptsString) }
            .isExactlyInstanceOf(NumberFormatException::class.java)
    }

    @DisplayName("NumberOfAttempts 인스턴스 hashCode and equals 일치 테스트")
    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(strings = ["0", "1", "10", "100"])
    fun hashCode_and_equals_test(numberOfAttemptsString: String) {
        // given
        val one = NumberOfAttempts(numberOfAttemptsString)
        val other = NumberOfAttempts(numberOfAttemptsString)

        // when and then
        assertAll(
            { Assertions.assertThat(one).hasSameHashCodeAs(other) },
            { Assertions.assertThat(one).isEqualTo(other) },
        )
    }

    @DisplayName("NumberOfAttempts 인스턴스 getter 테스트")
    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(strings = ["0", "1", "10", "100"])
    fun getter_test(numberOfAttemptsString: String) {
        // given
        val expected = numberOfAttemptsString.toInt()
        val numberOfAttempts = NumberOfAttempts(numberOfAttemptsString)

        // when
        val actual = numberOfAttempts.numberOfAttempts

        // then
        assertAll(
            { Assertions.assertThat(actual).isNotNull() },
            { Assertions.assertThat(actual).isEqualTo(expected) },
        )
    }
}

fun createTestNumberOfAttempts() = NumberOfAttempts(1)
