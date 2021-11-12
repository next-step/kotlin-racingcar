package racingcar.domain.racing

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("총 몇바퀴를 진행할지 담당하는 객체인 FinalLab 테스트")
internal class FinalLabTest {
    @DisplayName("0보다 큰 수가 주어지면 `FinalLab` 생성 시 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 17, 88, 100, 28_385, 2_218_356, 1_000_000_000])
    fun createFinalLabIsSuccessIfGivenNumberIsGreaterThanZero(givenFinalLab: Int) {
        // Arrange
        // Act
        val finalLab = FinalLab(givenFinalLab)

        // Assert
        assertThat(finalLab.value).isEqualTo(givenFinalLab)
    }

    @DisplayName("0과 같거나 작은 수가 주어지면 `FinalLab` 생성 시 실패")
    @ParameterizedTest
    @MethodSource("zeroOrNegativeValues")
    fun createFinalLabIsFailIfGivenNumberIsZeroOrSmallerThanZero(
        givenFinalLab: Int,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            FinalLab(givenFinalLab)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessages)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()
        private const val illegalArgumentErrorMessage = "Failed requirement"

        @JvmStatic
        fun zeroOrNegativeValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(-1, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-231, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-191_297, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-920_191_089, illegalArgumentException, illegalArgumentErrorMessage)
            )
        }
    }
}
