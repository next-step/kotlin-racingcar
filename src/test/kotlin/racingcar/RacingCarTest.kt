package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingCarTest {
    @ParameterizedTest
    @CsvSource("4, 1", "1, 0")
    fun `4이상인 경우에만 전진을한다`(condition: Int, expectedCardPosition: Int) {
        val racingCar = RacingCar(ArrayList())

        val car = racingCar.forwardByCondition(Car(), condition)

        assertThat(car.position).isEqualTo(expectedCardPosition)
    }

    @Test
    fun `RacingCar 에 등록된 모든 자동차가 조건에 맞는 경우 전진한다`() {
        val racingCar = RacingCar(listOf(Car(), Car(), Car()))

        val car = racingCar.forwardAllByCondition(listOf(1, 5, 9))

        assertAll(
            { assertThat(car[0].retrievePosition()).isEqualTo(0) },
            { assertThat(car[1].retrievePosition()).isEqualTo(1) },
            { assertThat(car[2].retrievePosition()).isEqualTo(1) }
        )
    }
}
