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
        val testCar = Car("test")
        val cars = listOf(Car("jade"), testCar)
        val winners = listOf(testCar)
        val outputView = TestOutputView()

        // when
        testCar.move(MustOneMoveStrategy())
        val result = outputView.getResult(cars, winners)

        // then
        assertThat(result).contains("0")
        assertThat(result).contains("1")
    }

    @Test
    fun `우승자 출력 테스트`() {
        // given
        val testCar1 = Car("test1")
        val testCar2 = Car("test2")
        val cars = listOf(testCar1, testCar2)
        val winners = listOf(testCar1)
        val outputView = TestOutputView()

        // when
        val result = outputView.getResult(cars, winners)

        // then
        assertThat(result).contains("test1가 최종 우승")
    }
}

class TestOutputView : OutputView {
    override fun getResult(cars: List<Car>, winners: List<Car>): String {
        return cars.joinToString("\n") { "${it.hashCode()}번 자동차 위치: ${it.position()}" }
            .plus("\n${winners.joinToString(", ") { it.name }}가 최종 우승")
    }
}
