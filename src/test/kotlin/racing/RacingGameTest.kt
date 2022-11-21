package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.CarFactory
import racing.domain.Cars
import racing.domain.Winner
import racing.ui.ResultView

class RacingGameTest {

    @Test
    fun `실행결과 출력`() {
        val names = "lee,kkoks"
        val cars: Cars = CarFactory.create(names)
        for (car in cars) {
            car.move(4)
        }

        val result = """
            lee : -
            kkoks : -
        """.trimIndent()
        assertThat(ResultView.toRaceResult(cars)).isEqualTo(result)
    }

    @Test
    fun `Racing Game 단독 우승자 출력`() {
        val leeCar = Car.produce("lee", 5)
        val kkoksCar = Car.produce("kkoks", 3)
        val winner = Winner(listOf(leeCar, kkoksCar))
        val result = winner.win()
        assertThat(result).isEqualTo("lee")
    }

    @Test
    fun `Racing Game 공동 우승자 출력`() {
        val leeCar = Car.produce("lee", 5)
        val kkoksCar = Car.produce("kkoks", 5)
        val winner = Winner(listOf(leeCar, kkoksCar))
        val result = winner.win()
        assertThat(result).isEqualTo("lee, kkoks")
    }
}
