package step3.racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("자동차 경주에서 현재 턴을 담당하는 객체인 CurrentTurn 테스트")
internal class CurrentTurnTest {
    @DisplayName("주어진 숫자가 올바른 경우 CurrentTurn 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 100_000, 1_000_000_000])
    fun given_CorrectValues_when_createCurrentTurn_then_Success(givenValue: Int) {
        // Arrange
        // Act
        val currentTurn = CurrentTurn(givenValue)

        // Assert
        assertThat(currentTurn.value).isEqualTo(givenValue)
    }

    @DisplayName("주어진 숫자가 올바르지 않은 경우 CurrentTurn 생성 실패")
    @ParameterizedTest
    @MethodSource("incorrectValues")
    fun given_IncorrectValues_when_createCurrentTurn_then_Fail(
        givenValue: Int,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            val currentTurn = CurrentTurn(givenValue)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessages)
    }

    @DisplayName("주어진 숫자가 올바른 경우 increaseTurn 함수 호출 시 증가 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 100_000, 1_000_000_000])
    fun given_CorrectValues_when_IncreaseTurn_then_Success(givenValue: Int) {
        // Arrange
        val currentTurn = CurrentTurn(0)

        // Act
        repeat((START..givenValue).count()) {
            currentTurn.increaseTurn()
        }

        // Assert
        assertThat(currentTurn.value).isEqualTo(givenValue)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()
        private const val ILLEGAL_ARGUMENT_ERROR_MESSAGE = "Failed requirement"
        private const val START = 1

        @JvmStatic
        fun incorrectValues(): Stream<Arguments> =
            Stream.of(
                Arguments.of(-1_000_000, illegalArgumentException, ILLEGAL_ARGUMENT_ERROR_MESSAGE),
                Arguments.of(-1_000, illegalArgumentException, ILLEGAL_ARGUMENT_ERROR_MESSAGE),
                Arguments.of(-1, illegalArgumentException, ILLEGAL_ARGUMENT_ERROR_MESSAGE),
            )
    }
}
