package step3.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racingcar.car.Car

class CarTest {

    @Test
    fun `4 이상 숫자가 나오면 움직인다`() {
        val moveNumber = 5
        val nonMoveNumber = 3
        val boundaryNumber = 4

        assertThat(Car().isMovable(moveNumber)).isTrue
        assertThat(Car().isMovable(nonMoveNumber)).isFalse
        assertThat(Car().isMovable(boundaryNumber)).isTrue
    }
}
