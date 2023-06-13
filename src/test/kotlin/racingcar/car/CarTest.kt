package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car(ManualMoveStrategy())
        assertThat(car.position).isZero()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 10, 100])
    fun `자동차를 움직이면 위치가 1씩 증가한다`(moveCount: Int) {
        val car = Car(ManualMoveStrategy())
        for (i: Int in 1.rangeTo(moveCount)) {
            car.move()
        }
        assertThat(car.position).isEqualTo(moveCount)
    }
}