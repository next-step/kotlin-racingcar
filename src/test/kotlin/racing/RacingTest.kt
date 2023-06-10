package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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
}
