package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.view.InputView
import racing.view.ResultView

class RacingTest {

    @ParameterizedTest
    @CsvSource("3,3")
    fun `자동차 경주 결과 출력`(n: Int, count: Int) {

        InputView.printInputCar()
        println(n)
        InputView.printInputCount()
        println(count)

        val cars = Racing().createCars(n)
        ResultView.printResult()
        Racing().carRacing(count, cars)
    }

    @ParameterizedTest
    @CsvSource("3")
    fun `자동차 입력 수 만큼 객체 생성 검증`(n: Int) {
        assertThat(Racing().createCars(n).size).isEqualTo(n)
    }
}
