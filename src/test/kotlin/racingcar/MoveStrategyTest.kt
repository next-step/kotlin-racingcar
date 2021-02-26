package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MoveStrategyTest {
    @ParameterizedTest
    @CsvSource(value = ["2:false", "3:false", "4:true", "5:true"], delimiter = ':')
    fun canMove(randomNumber: Int, expected: Boolean) {
        // when
        val canMove = MoveStrategy.canMove(randomNumber)

        // then
        assertThat(canMove).isEqualTo(expected)
    }
}
