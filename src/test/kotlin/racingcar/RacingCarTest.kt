package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RaceCondition

class RacingCarTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    fun `check car list count`() {
        val list = Cars(RaceCondition(3, 5)).carList
        assertThat(list.size).isEqualTo(3)
    }

    @Test
    @DisplayName("전진 테스트")
    fun `check move forward`() {
        val car = Car(movement = 0).move(5)
        assertThat(car.movement).isEqualTo(1)
    }

    @Test
    @DisplayName("정지 테스트")
    fun `check move stop`() {
        val car = Car(movement = 0).move(2)
        assertThat(car.movement).isEqualTo(0)
    }

    @Test
    @DisplayName("이동 결과 테스트")
    fun `check race result`() {
        val tryCount = 3
        val randomInt = listOf(2, 5, 6)
        val car = Car(movement = 0)

        for (i in 0 until tryCount) {
            car.move(randomInt[i])
        }

        assertThat(car.movement).isEqualTo(2)
    }

    @Test
    @DisplayName("경주 후 움직임 범위 테스트")
    fun `check range of movement`() {
        val cars = Cars(RaceCondition(1, 5))
        cars.race()
        assertThat(cars.carList[0].movement).isLessThan(5)
    }
}
