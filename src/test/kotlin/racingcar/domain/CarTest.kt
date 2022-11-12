package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `입력 값에 따른 Car 클래스 생성 개수 확인`() {
        val carList = Car.generateCar(1)
        assertThat(carList.size).isEqualTo(1)
    }
}
