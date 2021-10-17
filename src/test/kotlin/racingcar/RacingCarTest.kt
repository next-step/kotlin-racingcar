package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.DriveRule.Companion.FORWARD_NUMBER
import racingcar.model.Car
import racingcar.model.RaceCondition

class RacingCarTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    fun `check car list count`() {
        val list = Cars.createCars(RaceCondition(3, 5)).carList
        assertThat(list.size).isEqualTo(3)
        assertThat(list.size).isNotNull
    }

    @Test
    @DisplayName("전진 테스트")
    fun `check move forward`() {
        val car = Car(movement = 0).forward()
        assertThat(car.movement).isEqualTo(1)
    }

    @Test
    @DisplayName("정지 테스트")
    fun `check move stop`() {
        val car = Car(movement = 0).stop()
        assertThat(car.movement).isEqualTo(0)
    }

    @Test
    @DisplayName("Cars 클래스 테스트; 객체 생성 테스트 및 움직임 테스트")
    fun `check Cars class`() {
        val cars = Cars.createCars(RaceCondition(3, 5))
        assertThat(cars.carList).isEqualTo(listOf(Car(0), Car(0), Car(0)))
        assertThat(cars.carList).isNotNull
        cars.race()
        assertThat(cars.carList[0].movement).isLessThan(5)
        assertThat(cars.carList[0].movement).isNotNull
    }

    @Test
    @DisplayName("랜덤값 범위 테스트")
    fun `check DriveRule`() {
        val randomInt = DriveRule().random()
        assertThat(randomInt).isNotNull
        assertThat(randomInt).isLessThanOrEqualTo(9)
        assertThat(randomInt).isGreaterThanOrEqualTo(0)
    }

    @Test
    @DisplayName("전진하는 기준 값 테스트")
    fun `check value of forward standard`() {
        assertThat(FORWARD_NUMBER).isEqualTo(4)
    }
}
