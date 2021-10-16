package domain.step3.domain.configuration

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberOfCarsTest {

    @DisplayName("NumberOfCars 인스턴스 생성 실패 테스트")
    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(strings = ["-100", "-10", "-1"])
    fun constructor_fail_test(numberOfCarsString: String) {
        assertThatThrownBy { NumberOfCars(numberOfCarsString) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("NumberOfCars 가 허용하는 범위 밖의 숫자가 입력 되었습니다.")
    }
}
