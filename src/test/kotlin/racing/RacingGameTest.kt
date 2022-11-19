package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.CarFactory
import racing.domain.Cars
import racing.domain.ResultStatistics
import racing.domain.Winner

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
        assertThat(ResultStatistics(cars).toResult()).isEqualTo(result)
    }

    @Test
    fun `Racing Game 단독 우승자 출력`() {
        val leeCar = Car("lee", 5)
        val kkoksCar = Car("kkoks", 3)
        val winner = Winner(listOf(leeCar, kkoksCar))
        val result = winner.win()
        assertThat(result).contains(leeCar)
    }

    @Test
    fun `Racing Game 공동 우승자 출력`() {
        val leeCar = Car("lee", 5)
        val kkoksCar = Car("kkoks", 5)
        val winner = Winner(listOf(leeCar, kkoksCar))
        val result = winner.win()
        assertThat(result).containsAll(listOf(leeCar, kkoksCar))
    }
}
