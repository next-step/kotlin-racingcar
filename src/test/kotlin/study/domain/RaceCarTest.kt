package study.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceCarTest {
    @Test
    fun getPosition() {
        val raceCar = RaceCar()
        assertThat(raceCar.getPosition()).isZero
    }

    @Test
    fun move() {
        val raceCar = RaceCar()
        raceCar.move()
        assertThat(raceCar.getPosition()).isOne
    }
}
