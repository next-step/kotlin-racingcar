package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CarTest {

    @Test
    fun `차 개수 입력 값에 따른 Car 클래스 생성 개수 확인`() {
        val carList = Car.generateCarByCount(1)
        assertThat(carList.size).isEqualTo(1)
    }

    @Test
    fun `차 이름이 다섯 자리가 넘어가면 에러 발생하는지 확인`() {
        val car = Car(1, "12345")
        assertThrows<IllegalArgumentException> { car.valid() }
    }

    @Test
    fun `차 이름 입력 값에 따른 Car 클래스 생성 확인`() {
        val names = listOf("가", "나", "다")
        val carList = Car.generateCarByName(names)
        assertThat(carList.size).isEqualTo(3)
        assertThat(carList[0].route).isEqualTo(0L)
        assertThat(carList[0].name).isEqualTo("가")
    }
}
