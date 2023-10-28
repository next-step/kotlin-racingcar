package study.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.CarManager

class CarManagerTest {

    // 자동차 생성
    // 자동차 이동
    @Test
    fun `출전할 자동차를 생성하고, 특정 번호의 자동차가 이동하면, 해당 자동차의 위치가 변경된다`() {
        // given : 4대의 자동차를 생성한다.
        CarManager.createCarList(4)

        // when : 0, 2, 3 번 자동차가 이동을 한다.
        val isMoveList = mutableListOf(true, false, true, true)

        for ((i, isMove) in isMoveList.withIndex()) {
            CarManager.moveCar(i, isMove)
        }

        // then : 0, 2, 3 번 자동차의 포지션이 늘었다.
        assertThat(CarManager.getCarPosition(0)).isEqualTo(2)
        assertThat(CarManager.getCarPosition(1)).isEqualTo(1)
        assertThat(CarManager.getCarPosition(2)).isEqualTo(2)
        assertThat(CarManager.getCarPosition(3)).isEqualTo(2)
    }
}
