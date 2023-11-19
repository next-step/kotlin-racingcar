package racing.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.car.Car

class CarTest {

    @Test
    fun `자동차의 첫 위치는 0이다`() {
        val car = Car()

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `랜덤 결과 움직이는 경우`() {
        val car = Car()
        val condition = 8

        car.move(condition)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `랜덤 결과 안 움직이는 경우`() {
        val car = Car()
        val condition = 1

        car.move(condition)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차 이름을 설정한다`() {
        val name = "지훈"
        val carWithName = Car(name)
        assertThat(carWithName.name).isEqualTo(name)
    }

    @Test
    fun `자동차는 이름을 주지 않더라도 기본 이름을 가진다`() {
        val car = Car()
        assertThat(car.name).isEqualTo("이름 없음")
    }
}
