package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.assertj.core.util.Arrays
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.CarFactory
import racing.domain.Cars
import racing.domain.Winner
import racing.view.ResultView

class RacingGameTest {

    @Test
    fun `실행결과 출력`() {
        val names = Arrays.array("lee", "kkoks")
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
    fun `Racing Game 단독 우승자 출력(차가 한대일경우)`() {
        val kkoksCar = Car.produce("kkoks", 3)
        val winner = Winner(Cars(listOf(kkoksCar)))
        val result = winner.win()
        assertThat(result).contains(kkoksCar)
    }

    @Test
    fun `Racing Game 단독 우승자 출력`() {
        val leeCar = Car.produce("lee", 5)
        val kkoksCar = Car.produce("kkoks", 3)
        val winner = Winner(Cars(listOf(leeCar, kkoksCar)))
        val result = winner.win()
        assertThat(result).contains(leeCar)
    }

    @Test
    fun `Racing Game 공동 우승자 출력`() {
        val leeCar = Car.produce("lee", 5)
        val kkoksCar = Car.produce("kkoks", 5)
        val tesyCar = Car.produce("tesy", 3)
        val winner = Winner(Cars(listOf(leeCar, kkoksCar, tesyCar)))
        val result = winner.win()
        assertThat(result).contains(leeCar, kkoksCar)
    }
}
