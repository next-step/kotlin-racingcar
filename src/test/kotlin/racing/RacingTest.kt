package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.domain.Car
import racing.view.InputView
import racing.view.ResultView

class RacingTest {

    @ParameterizedTest
    @CsvSource("3,3")
    fun `자동차 경주 결과 출력`(carCount: Int, tryCount: Int) {

        InputView.printInputCar()
        println(carCount)
        InputView.printInputCount()
        println(tryCount)

        val cars = Racing().createCars(carCount)
        ResultView.printResult()
        Racing().carRacing(tryCount, cars)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `자동차 입력 수 만큼 객체 생성 검증`(carCount: Int) {
        assertThat(Racing().createCars(carCount).size).isEqualTo(carCount)
    }

    @ParameterizedTest
    @CsvSource("5")
    fun `4 이상의 랜덤 숫자가 나와 자동차 이동 검증`(randomNumber: Int) {

        val car = Car()
        Racing().moveAndStop(car, randomNumber)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `4 이상의 랜덤 숫자가 나오지 않을 시 자동차 정지 검증`(randomNumber: Int) {

        val car = Car()
        Racing().moveAndStop(car, randomNumber)
        assertThat(car.position).isEqualTo(0)
    }
}
