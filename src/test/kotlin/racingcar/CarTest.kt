package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun runOneCarWhenCanMove(prevScore: Int) {
        // given
        val car = Car()
        car.score = prevScore
        val canMove = true

        // when
        car.move(canMove)

        // then
        assertThat(car.score).isEqualTo(prevScore + 1)
    }

    @ParameterizedTest
    @CsvSource(value = ["true:1", "false:0"], delimiter = ':')
    fun onlyIncreaseScoreWhenCanMove(canMove: Boolean, score: Int) {
        // given
        val car = Car()

        // when
        car.move(canMove)

        // then
        assertThat(car.score).isEqualTo(score)
    }
}
