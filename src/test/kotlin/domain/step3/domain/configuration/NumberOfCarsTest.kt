package domain.step3.domain.configuration

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberOfCarsTest {

    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(strings = ["-100", "-10", "-1", "0"])
    fun `허용하는 범위 밖의 값이 들어오면 객체 생성에 실패한다`(numberOfCarsString: String) {
        assertThatThrownBy { NumberOfCars(numberOfCarsString) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("NumberOfCars 가 허용하는 범위 밖의 숫자가 입력 되었습니다.")
    }

    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(strings = ["일", "오", "영", "마이너스 일"])
    fun `숫자로 변환될 수 없는 값이 들어오면 객체 생성에 실패한다`(numberOfCarsString: String) {
        assertThatThrownBy { NumberOfCars(numberOfCarsString) }
            .isExactlyInstanceOf(NumberFormatException::class.java)
    }

    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(strings = ["1", "10", "100"])
    fun `동일한 값을 포함하고 있으면 동일한 객체이다`(numberOfCarsString: String) {
        // given
        val one = NumberOfCars(numberOfCarsString)
        val other = NumberOfCars(numberOfCarsString)

        // when and then
        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) },
        )
    }

    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(strings = ["1", "10", "100"])
    fun `가지고 있는 값을 반환한다`(numberOfCarsString: String) {
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
