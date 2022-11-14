package src.step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `랜덤 값이 4 이상이면 자동차가 움직인다`() {
        val randomValue = 4
        val carMoveCount = Car().move(1, randomValue).getMoveCountIndex(0)
        Assertions.assertThat(carMoveCount).isEqualTo(1)
    }

    @Test
    fun `랜덤 값이 4 미만이면 자동차가 멈춘다`() {
        val randomValue = 3
        val carMoveCount = Car().move(1, randomValue).getMoveCountIndex(0)
        Assertions.assertThat(carMoveCount).isEqualTo(0)
    }
}
