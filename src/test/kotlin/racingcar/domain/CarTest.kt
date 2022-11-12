package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CarTest {

    @Test
    fun `입력 값에 따른 Car 클래스 생성 개수 확인`() {
        val carList = Car.generateCar(1)
        assertThat(carList.size).isEqualTo(1)
    }

    @Test
    fun `차 이름이 다섯 자리가 넘어가면 에러 발생하는지 확인`() {
        val car = Car(1, "12345")
        assertThrows<IllegalArgumentException> { car.valid() }
    }
}
