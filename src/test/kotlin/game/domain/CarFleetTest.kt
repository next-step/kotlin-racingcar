package game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarFleetTest {

    private val advance = 4

    @Test
    fun `자동차 이름으로 자동차들을 생성한다`() {
        // given
        val carNames = listOf("pobi", "crong", "honux")

        // when
        val carFleet = CarFleet.of(carNames, FixedMoveConditionGenerator(advance))

        // then
        assertThat(carFleet.cars.map { it.name }).containsExactly("pobi", "crong", "honux")
    }
}
