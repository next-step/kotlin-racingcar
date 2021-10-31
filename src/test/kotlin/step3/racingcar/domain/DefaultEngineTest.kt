package step3.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("전진 여부를 결정할 기준 값을 랜덤 값으로 생성하는 객체인 DefaultEngine 테스트")
internal class DefaultEngineTest {
    @DisplayName("DefaultEngine 객체를 통해 랜덤 값 생성 시 0부터 9까지의 값만 생성")
    @ParameterizedTest
    @MethodSource("correctRangeValues")
    fun given_Anytime_when_CreateRandomValue_then_ReturnBetweenZeroAndNine(
        loopCount: Int,
        startRange: Int,
        endRange: Int
    ) {
        // Arrange
        val engine: Engine = DefaultEngine()

        // Act
        repeat((1..loopCount).count()) {
            // Assert
            assertThat(engine.generateCriterionValueToRace()).isBetween(startRange, endRange)
        }
    }

    companion object {
        @JvmStatic
        fun correctRangeValues(): Stream<Arguments> =
            Stream.of(
                Arguments.of((1..9).random(), 0, 9),
                Arguments.of((1..9).random(), 0, 9),
                Arguments.of((1..9).random(), 0, 9),
                Arguments.of((1..9).random(), 0, 9),
            )
    }
}
