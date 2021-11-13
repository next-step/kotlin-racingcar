package racingcar.domain.racing

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("주행 거리(현재 위치)를 표현하는 객체인 `RacingDistance` 테스트")
internal class RacingDistanceTest {
    @DisplayName("0 이상의 값이 주어지면 `RacingDistance` 객체 생성 시 성공")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 100, 3_824, 58_102, 1_000_000, 2_000_000_000])
    fun createRacingDistanceIsSuccessIfGivenNumberIsPositiveValue(startingPoint: Int) {
        // Arrange
        // Act
        val racingDistance = RacingDistance(value = startingPoint)

        // Assert
        assertThat(racingDistance.value).isEqualTo(startingPoint)
    }

    @DisplayName("음수의 값이 주어지면 `RacingDistance` 객체 생성 시 실패")
    @ParameterizedTest
    @MethodSource("negativeValues")
    fun createRacingDistanceIsFailIfGivenNumberIsNegativeValue(
        negativeIntValue: Int,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            RacingDistance(value = negativeIntValue)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessages)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()
        private const val illegalArgumentErrorMessage = "Failed requirement"

        @JvmStatic
        fun negativeValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(-1, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-231, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-191_297, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-920_191_089, illegalArgumentException, illegalArgumentErrorMessage)
            )
        }
    }
}
