package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RaceCondition

class CarsTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    fun `check car list count`() {
        val list = Cars.createCars(RaceCondition(3, 5)).carList
        Assertions.assertThat(list.size).isEqualTo(3)
        Assertions.assertThat(list.size).isNotNull
    }

    @Test
    @DisplayName("Cars 클래스 테스트; 객체 생성 테스트 및 움직임 테스트")
    fun `check Cars class`() {
        val cars = Cars.createCars(RaceCondition(3, 5))
        Assertions.assertThat(cars.carList).isEqualTo(listOf(Car(0), Car(0), Car(0)))
        Assertions.assertThat(cars.carList).isNotNull
        cars.race()
        Assertions.assertThat(cars.carList[0].movement).isLessThan(5)
        Assertions.assertThat(cars.carList[0].movement).isNotNull
    }
}
