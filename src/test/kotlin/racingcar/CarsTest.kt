package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.Exception
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RaceCondition

class CarsTest {
    @Test
    @DisplayName("자동차 객체 생성 테스트")
    fun `check car list count`() {
        val list = Cars.createCars(RaceCondition("아,하,다", 5)).carList
        Assertions.assertThat(list.size).isEqualTo(3)
        Assertions.assertThat(list.size).isNotNull
    }

    @Test
    @DisplayName("Cars 클래스 테스트; 객체 생성 테스트 및 움직임 테스트")
    fun `check Cars class`() {
        val cars = Cars.createCars(RaceCondition("아,하,다", 5))
        Assertions.assertThat(cars.carList)
            .isEqualTo(listOf(Car(name = "아"), Car(name = "하"), Car(name = "다")))
        Assertions.assertThat(cars.carList).isNotNull
        cars.race()
        Assertions.assertThat(cars.carList[0].movement).isLessThan(5)
        Assertions.assertThat(cars.carList[0].movement).isNotNull
    }

    @ParameterizedTest
    @ValueSource(strings = [",", "123456,3434아", "바람,사탕,", "얼마나긴이름을지을수있을까"])
    @DisplayName("차 이름 잘못 입력한 경우")
    fun `check car name validation`(names: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Cars.splitNameOfCars(names) }
            .withMessage(Exception.CASE_INCORRECT_FORMAT_NAME_OF_CAR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["바람,사탕,별,나부"])
    @DisplayName("차 이름 옳바르게 입력한 경우")
    fun `check car name validation when input correct name of car`(names: String) {
        val list = Cars.splitNameOfCars(names)

        Assertions.assertThat(list.size).isNotNull
        Assertions.assertThat(list.size).isEqualTo(4)
        Assertions.assertThat(list).isEqualTo(listOf("바람", "사탕", "별", "나부"))
    }

    @Test
    @DisplayName("우승자는 1명 이상일 수 있다.")
    fun `check number of race winner`() {
        val cars = Cars.createCars(RaceCondition("바람,하늘,다리", 3))

        repeat(5) {
            cars.race()
        }

        Assertions.assertThat(cars.getWinner().size).isGreaterThanOrEqualTo(1)
    }
}
