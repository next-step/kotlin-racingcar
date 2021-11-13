package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.CarName

class ResultViewTest {

    @Test
    fun `우승자 이름 나열하기`() {
        //given
        val cars = listOf(Car(CarName("자동차1")),Car(CarName("자동차2")),Car(CarName("자동차3")))

        // when
        val actual = ResultView.racingWinnerName(cars)

        // then
        assertThat(actual).isEqualTo("자동차1, 자동차2, 자동차3")
    }
}
