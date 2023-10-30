package study.racing.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.car.CarManager

class CarManagerTest {

    // 자동차 생성
    // 자동차 이동
    @Test
    fun `CarManager의createCarList(num)을 요청하면 ,position이 1인 출전 차량이 num만큼의 생성된다`() {
        // when : 4대의 차량 생성을 요청한다.
        CarManager.createCarList(4)

        // then : position이 1인 4대의 차량이 생성된다.
        val expect = listOf(1, 1, 1, 1)

        assertThat(CarManager.getCarPositionList()).isEqualTo(expect)
    }
}
