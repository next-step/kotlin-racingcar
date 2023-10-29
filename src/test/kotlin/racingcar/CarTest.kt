package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차의 초기 위치는 0이다`() {
        val moveCondition = OnlyTrueMoveCondition()
        val car = Car(moveCondition)

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `MoveCondition의 canForward 조건이 참이면 차가 움직일 수 있다`() {
        val moveCondition = OnlyTrueMoveCondition()
        val car = Car(moveCondition)

        car.tryMove()

        assertThat((car.position)).isEqualTo(1)
    }

    @Test
    fun `MoveCondition의 canForward 조건이 거짓이면 차가 움직일 수 있다`() {
        val moveCondition = OnlyFalseMoveCondition()
        val car = Car(moveCondition)

        car.tryMove()

        assertThat((car.position)).isEqualTo(0)
    }
}
