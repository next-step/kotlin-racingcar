package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    
    @Test
    fun `자동차_전진`() {
        val car = Car()
        val moveResult = car.move(MOVE_NUMBER)
        assertThat(moveResult).isEqualTo(1)
    }

    @Test
    fun `자동차_멈춤`() {
        val car = Car()
        val moveResult = car.move(MOVE_NUMBER - 1)
        assertThat(moveResult).isEqualTo(0)
    }

    companion object {
        const val MOVE_NUMBER = 4
    }
}