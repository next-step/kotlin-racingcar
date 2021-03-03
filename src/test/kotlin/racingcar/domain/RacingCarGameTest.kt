package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RacingCarGameTest {

    @ParameterizedTest
    @MethodSource("provideCarCountAndAttemptCount")
    internal fun `자동차 수, 총 시도 횟수 테스트`(carCount: Int, attemptCount: Int) {
        val result = RacingCarGame(carCount = 3).play(attemptCount = 4, shouldMove = true)
        assertThat(result.size).isEqualTo(3)
        result.forEach {
            assertThat(it.history.size).isEqualTo(4)
            assertThat(it.history).isEqualTo(List(4) { CarAction.MOVE })
        }
    }

    companion object {
        @JvmStatic
        private fun provideCarCountAndAttemptCount(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(3, 5),
                Arguments.of(10, 20)
            )
        }
    }
}
