package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.cars.Position
import java.util.stream.Stream

@DisplayName("위치를 표현하는 객체인 Position 테스트")
internal class PositionTest {
    @DisplayName("주어진 거리 값이 올바른 경우 Position 객체 생성 시 성공")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 100, 3_824, 58_102, 1_000_000, 2_000_000_000])
    fun given_CorrectPositionValue_when_CreatePosition_then_Success(correctIntValue: Int) {
        // Arrange
        // Act
        val position = Position(correctIntValue)

        // Assert
        assertThat(position.value).isEqualTo(correctIntValue)
    }

    @DisplayName("주어진 거리 값이 음수인 경우 Position 객체 생성 시 예외 발생")
    @ParameterizedTest
    @MethodSource("negativeValues")
    fun given_IncorrectPositionValue_when_CreatePosition_then_ThrowIllegalArgumentException(
        negativeIntValue: Int,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            Position(negativeIntValue)
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
