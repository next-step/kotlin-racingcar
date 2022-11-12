package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `입력 값에 따른 Car 클래스 생성 개수 확인`() {
        val carList = Car().generateCar(1)
        assertThat(carList.size).isEqualTo(1)
    }

    @Test
    fun `생성 Car 이동경로가 모두 비어있는지 확인`() {
        val carList = Car().generateCar(3)
        assertThat(carList.map { it.getRoute() }).containsOnly("")
    }

    @Test
    fun `이동 명령 시 route 추가 확인`() {
        val car = Car()
        car.move()
        assertThat(car.getRoute()).isEqualTo("-")
    }
}
