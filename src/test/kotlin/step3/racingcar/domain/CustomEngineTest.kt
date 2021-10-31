package step3.racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("전진 여부를 결정할 기준 값을 파라미터 값으로 생성하는 객체인 CustomEngine 테스트")
internal class CustomEngineTest {
    @DisplayName("주어진 기준 값이 올바른 경우 생성한 CustomEngine의 값과 기준 값이 동일")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun given_CorrectCriterionValue_when_CustomEngineCriterionValue_then_SameGivenCriterionValue(
        givenCriterion: Int
    ) {
        // Arrange
        val engine: Engine = CustomEngine(givenCriterion)

        // Act
        val resultCriterion = engine.generateCriterionValueToRace()

        // Assert
        assertThat(resultCriterion).isEqualTo(givenCriterion)
    }

    @DisplayName("주어진 기준 값이 올바르지 않은 경우 CustomEngine 생성 시 실패")
    @ParameterizedTest
    @MethodSource("incorrectCriterionValues")
    fun given_inCorrectCriterionValue_when_CreateCustomEngine_then_Fail(
        givenCriterion: Int,
        expectedException: Exception,
        containErrorMessage: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            CustomEngine(givenCriterion)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessage)
    }

    companion object {
        private const val illegalArgumentErrorMessage = "Failed requirement"
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun incorrectCriterionValues(): Stream<Arguments> =
            Stream.of(
                Arguments.of(-1, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-123_456, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-920_109_784, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(10, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(839_187, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(100_000_000, illegalArgumentException, illegalArgumentErrorMessage),
            )
    }
}
