package racinggame

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racinggame.car.Engine
import racinggame.car.RacingCar

internal class RacingCarTest {
    @CsvSource(value = ["true,1", "false,0"])
    @ParameterizedTest
    fun `움직이기 테스트`(movable: Boolean, expect: Int) {
        // given
        val racingCar = RacingCar(
            "testName",
            object : Engine {
                override fun enoughPower(): Boolean {
                    return movable
                }
            }
        )

        // when
        racingCar.move()

        // then
        assertThat(racingCar.distance).isEqualTo(expect)
    }
}
