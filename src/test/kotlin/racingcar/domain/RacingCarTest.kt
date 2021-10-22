package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.strategy.MockRandomMovingStrategy
import racingcar.fixture.NameFixture

class RacingCarTest {

    @ParameterizedTest
    @CsvSource("0, 1", "1, 1", "2, 1", "3, 1")
    fun `0이상 3이하의 값이 나오면 자동차는 움직일 수 없다`(value: Int, start: Int) {
        // given
        val car = RacingCar(NameFixture.VALID_NAME, MockRandomMovingStrategy(value), Position.of(start))

        // when
        val moved = car.move()

        // then
        assertThat(moved.position).isEqualTo(Position.of(start))
    }

    @ParameterizedTest
    @CsvSource("4, 1, 2", "7, 1, 2", "8, 2, 3", "9, 4, 5")
    fun `4이상의 값이 나오면 자동차는 앞으로 1만큼 움직일 수 있다`(value: Int, start: Int, end: Int) {
        // given
        val car = RacingCar(NameFixture.VALID_NAME, MockRandomMovingStrategy(value), Position.of(start))

        // when
        val moved = car.move()

        // then
        assertThat(moved.position).isEqualTo(Position.of(end))
    }
}
