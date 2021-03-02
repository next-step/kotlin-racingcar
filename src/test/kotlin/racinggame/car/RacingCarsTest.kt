package racinggame.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarsTest {

    @Test
    fun `전체 자동차를 움직인다`() {
        // given
        val racingCar1 = RacingCar(
            "testName1",
            object : Engine {
                override fun enoughPower() = true
            }
        )
        val racingCar2 = RacingCar(
            "testName2",
            object : Engine {
                override fun enoughPower() = true
            }
        )
        val racingCars = RacingCars(listOf(racingCar1, racingCar2))

        // when
        racingCars.move(1)

        val recorder = racingCars.recorder

        // then
        assertThat(recorder.records).hasSize(1)
        assertThat(recorder.records[0].records).hasSize(2)
        assertThat(recorder.records[0].records[0].distance).isEqualTo(1)
        assertThat(recorder.records[0].records[1].distance).isEqualTo(1)
    }
}
