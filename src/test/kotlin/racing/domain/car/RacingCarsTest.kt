package racing.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racing.domain.movement.GoForwardMoveStrategy

internal class RacingCarsTest {

    @DisplayName("자동차를 전진시킨 경우 전진한 RacingCar의 리스트들을 반환")
    @Test
    fun race() {
        val racingCars = RacingCarFactory.createRacingCars("pobi,crong")
        val expected = createRacingRecord()

        val actual = racingCars.race(2, GoForwardMoveStrategy())

        assertAll(
            { assertThat(actual.size).isEqualTo(expected.size) },
            { assertThat(actual[0].size).isEqualTo(expected[0].size) },
            { assertThat(actual[1].size).isEqualTo(expected[1].size) }
        )
    }

    private fun createRacingRecord(): List<List<RacingCar>> = listOf(
        listOf(createRacingCar("pobi", 1), createRacingCar("crong", 1)),
        listOf(createRacingCar("pobi", 2), createRacingCar("crong", 2)),
    )
}
