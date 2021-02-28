package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {
    @Test
    fun runOneCarWhenCanMove() {
        // given
        val car = Car("Elon")
        assertThat(car.score).isEqualTo(0)
        val canMove = true

        // when
        car.move(canMove)

        // then
        assertThat(car.score).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(value = ["true:1", "false:0"], delimiter = ':')
    fun onlyIncreaseScoreWhenCanMove(canMove: Boolean, score: Int) {
        // given
        val car = Car("Elon")

        // when
        car.move(canMove)

        // then
        assertThat(car.score).isEqualTo(score)
    }
}
