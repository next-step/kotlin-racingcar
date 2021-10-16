package domain.step3.domain.configuration

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberOfCarsTest {

    @DisplayName("NumberOfCars 인스턴스 생성시 범위 실패 테스트")
    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(strings = ["-100", "-10", "-1"])
    fun constructor_range_fail_test(numberOfCarsString: String) {
        assertThatThrownBy { NumberOfCars(numberOfCarsString) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("NumberOfCars 가 허용하는 범위 밖의 숫자가 입력 되었습니다.")
    }

    @DisplayName("NumberOfCars 인스턴스 생성시 Int 변환 실패 테스트")
    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(strings = ["일", "오", "영", "마이너스 일"])
    fun constructor_format_fail_test(numberOfCarsString: String) {
        assertThatThrownBy { NumberOfCars(numberOfCarsString) }
            .isExactlyInstanceOf(NumberFormatException::class.java)
    }

    @DisplayName("NumberOfCars 인스턴스 hashCode and equals 일치 테스트")
    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(strings = ["0", "1", "10", "100"])
    fun constructor_hashCode_and_equals_test(numberOfCarsString: String) {
        // given
        val one = NumberOfCars(numberOfCarsString)
        val other = NumberOfCars(numberOfCarsString)

        // when and then
        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) },
        )
    }

    @DisplayName("NumberOfCars 인스턴스 getter 테스트")
    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(strings = ["0", "1", "10", "100"])
    fun constructor_getter_test(numberOfCarsString: String) {
        // given
        val expected = numberOfCarsString.toInt()
        val numberOfCars = NumberOfCars(numberOfCarsString)

        // when
        val actual = numberOfCars.numberOfCars

        // then
        assertAll(
            { assertThat(actual).isNotNull() },
            { assertThat(actual).isEqualTo(expected) },
        )
    }
}

fun createTestNumberOfCars() = NumberOfCars(1)
