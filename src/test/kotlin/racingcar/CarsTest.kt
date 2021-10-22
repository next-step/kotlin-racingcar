package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.Exception
import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.model.DriveRule
import racingcar.model.RaceCondition
import racingcar.view.InputView.Companion.splitNameOfCars

class CarsTest {
    private val rule = DriveRule()

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    fun `check car list count`() {
        val list = Cars.createCars(RaceCondition(listOf(CarName("11"), CarName("22"), CarName("33")), 5), rule).carList
        Assertions.assertThat(list.racingCars.size).isEqualTo(3)
        Assertions.assertThat(list.racingCars.size).isNotNull
    }

    @Test
    @DisplayName("Cars 클래스 테스트; 객체 생성 테스트 및 움직임 테스트")
    fun `check Cars class`() {
        val cars = Cars.createCars(RaceCondition(listOf(CarName("사람"), CarName("사람3"), CarName("사람5")), 5), rule)
        Assertions.assertThat(cars.carList)
            .isEqualTo(listOf(CarName("사람"), CarName("사람3"), CarName("사람5")))
        Assertions.assertThat(cars.carList).isNotNull
        cars.getResult()
        Assertions.assertThat(cars.carList.racingCars[0].movement).isLessThan(5)
        Assertions.assertThat(cars.carList.racingCars[0].movement).isNotNull
    }

    @ParameterizedTest
    @ValueSource(strings = [",", "123456,3434아", "바람,사탕,", "얼마나긴이름을지을수있을까"])
    @DisplayName("차 이름 잘못 입력한 경우")
    fun `check car name validation`(names: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { splitNameOfCars(names) }
            .withMessage(Exception.CASE_INCORRECT_FORMAT_NAME_OF_CAR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["바람,사탕,별,나부"])
    @DisplayName("차 이름 옳바르게 입력한 경우")
    fun `check car name validation when input correct name of car`(names: String) {
        val list = splitNameOfCars(names)

        Assertions.assertThat(list.size).isNotNull
        Assertions.assertThat(list.size).isEqualTo(4)
        Assertions.assertThat(list).isEqualTo(listOf("바람", "사탕", "별", "나부"))
    }

    @Test
    @DisplayName("우승자는 1명 이상일 수 있다.")
    fun `check number of race winner`() {
        val cars = Cars.createCars(RaceCondition(listOf(CarName("바람"), CarName("구름"), CarName("사달")), 3), rule)

        Assertions.assertThat(cars.getResult().winners.size).isGreaterThanOrEqualTo(1)
    }
}
