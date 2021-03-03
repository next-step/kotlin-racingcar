package step3_racing_car.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlayerTest {
    @Test
    fun registerTest() {
        // given
        val numOfCar = 5
        // when
        Player.register(numOfCar)
        // then
        assertThat(Player.cars.size).isEqualTo(numOfCar)
    }
}
