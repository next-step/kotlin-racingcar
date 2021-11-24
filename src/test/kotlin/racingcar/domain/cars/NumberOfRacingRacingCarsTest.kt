package racingcar.domain.cars

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("Cars 객체의 자동차 수를 담당하는 객체인 NumberOfRacingCars 테스트")
internal class NumberOfRacingRacingCarsTest {
    @DisplayName("주어진 자동차 수가 양수이면 NumberOfRacingCar 객체 생성 시 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 189, 100_000, 200_442, 3_092_122])
    fun createNumberOfRacingCarsIsSuccessIfGivenPositiveValue(givenNumberOfRacingCars: Int) {
        // Arrange
        // Act
        val numberOfRacingCars = NumberOfRacingCars(givenNumberOfRacingCars)

        // Assert
        assertThat(numberOfRacingCars.value).isEqualTo(givenNumberOfRacingCars)
    }

    @DisplayName("주어진 자동차 수가 음수이면 NumberOfRacingCar 객체 생성 시 실패")
    @ParameterizedTest
    @MethodSource("negativeNumberOfCarsValues")
    fun createNumberOfRacingCarsIsFailIfGivenNegativeValue(
        givenNumberOfCars: Int,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            NumberOfRacingCars(givenNumberOfCars)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessages)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()
        private const val illegalArgumentErrorMessage = "Failed requirement"

        @JvmStatic
        fun negativeNumberOfCarsValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(-1, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-231, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-191_297, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-920_191_089, illegalArgumentException, illegalArgumentErrorMessage)
            )
        }
    }
}
