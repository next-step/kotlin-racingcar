package domain.step3.domain.configuration

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
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
}
