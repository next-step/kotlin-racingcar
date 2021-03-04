package step4_racing_car_winner.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlayerTest {
    @Test
    fun registerTest() {
        // given
        val nameOfCars = "test1,test2,test3"
        // when
        Player.register(nameOfCars)
        // then
        assertThat(Player.cars.size).isEqualTo(3)
    }
}
