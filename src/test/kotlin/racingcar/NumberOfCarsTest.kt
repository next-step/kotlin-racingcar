package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class NumberOfCarsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["-1", "0", "10", "a", "!", "?"])
    fun `잘못된 자동차 대수를 입력하면 IllegalArgumentException이 발생한다`(input: String?) {
        Assertions.assertThatThrownBy {
            NumberOfCars(input?.toIntOrNull())
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `정상적인 자동차 대수 입력 테스트`(input: Int) {
        val numberOfCars = NumberOfTrials(input)

        Assertions.assertThat(numberOfCars.value).isEqualTo(input)
    }
}
