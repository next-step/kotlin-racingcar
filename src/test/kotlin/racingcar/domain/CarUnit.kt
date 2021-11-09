package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarUnit {
    
    @Test
    fun `자동차_4이상일 때_전진`() {
        // given
        val car = Car()

        // when
        val moveResult = car.move(MOVE_NUMBER)

        // then
        assertThat(moveResult).isEqualTo(1)
    }

    @Test
    fun `자동차_4이하일 경우_멈춤`() {
        val car = Car()
        val moveResult = car.move(MOVE_NUMBER - 1)
        assertThat(moveResult).isEqualTo(0)
    }

    private companion object {
        const val MOVE_NUMBER = 4
    }
}