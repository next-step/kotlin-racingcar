package game.racingcar.view

import game.racingcar.domain.Car
import game.racingcar.strategy.MustOneMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("게임 설정 값 출력 인터페이스 테스트")
internal class OutputViewTest {

    @Test
    fun `정상 출력 테스트`() {
        // given
        val testCar = Car()
        val cars = listOf(Car(), testCar)
        val outputView = TestOutputView()

        // when
        testCar.move(MustOneMoveStrategy())
        val result = outputView.getResult(cars)

        // then
        assertThat(result).contains("0")
        assertThat(result).contains("1")
    }
}

class TestOutputView : OutputView {
    override fun getResult(cars: List<Car>): String {
        return cars.joinToString("\n") { "${it.hashCode()}번 자동차 위치: ${it.position()}" }
    }
}
