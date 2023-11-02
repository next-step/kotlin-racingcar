package game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarFleetTest {

    @Test
    fun `포함되여 있는 모든 자동차가 한번씩 조건에 따라 움직인다`() {
        // given
        val carFleet = CarFleet(Cars(Car.from(listOf("a", "b", "c"))), FixedMoveConditionGenerator(5))
        // when
        carFleet.advanceAll()
        // then
        assertThat(carFleet.cars.carList.all { it.position == 1 }).isTrue()
    }
}
