package racingcar.game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.game.vo.Position

internal class CarTest {
    @ParameterizedTest
    @CsvSource("0", "1", "2", "3")
    fun `기준값이 4 미만일 경우 차는 움직이지 않는다`(condition: Int) {
        // given
        val car = Car()
        // when
        car.move(condition)
        // then
        assertThat(car.position).isEqualTo(Position(START_LINE))
    }

    @ParameterizedTest
    @CsvSource("4", "5", "6", "7", "8", "9")
    fun `기준값이 4 이상일 경우 차는 움직인다`(input: Int) {
        // given
        val car = Car()
        // when
        car.move(input)
        // then
        assertThat(car.position).isEqualTo(Position(START_LINE + 1))
    }
}
