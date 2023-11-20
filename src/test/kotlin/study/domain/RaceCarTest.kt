package study.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceCarTest {
    @Test
    fun move() {
        val raceCar = RaceCar(CarName("name"))
        raceCar.move()
        assertThat(raceCar.position).isOne
    }

    @Test
    fun `이름이 5자 초과 시 에러`() {
        assertThrows<Exception> { RaceCar(CarName("name12")) }
    }
}
