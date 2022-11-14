package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GearTest {

    @Test
    @DisplayName("정해진 값이 4일 경우 FORWARD 조건")
    fun `FORWARD if value is 4`() {
        val random = 4
        val gear = Gear.getGear(random)
        assertThat(gear).isEqualTo(Gear.FORWARD)
    }

    @Test
    @DisplayName("정해진 값이 3일 경우 STOP 조건")
    fun `STOP if value is 3`() {
        val random = 3
        val gear = Gear.getGear(random)
        assertThat(gear).isEqualTo(Gear.STOP)
    }
}
