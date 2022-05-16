package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.domain.Car
import racing.domain.CarRacing
import racing.domain.StaticPowerStrategy

private fun TestCar(name: String, position: Int = 0) =
    Car(name = name, powerStrategy = StaticPowerStrategy(power = 10), startPosition = position)

class CarRacingTest {

    @Test
    fun `moveCount 가 0보다 작으면, IllegalArgumentException 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            CarRacing(
                cars = listOf(TestCar("Andy"), TestCar("Bruce")),
                moveCount = -1
            ).run()
        }
    }

    @Test
    fun `moveCount 이 2 일때, 모든 차량 위치와 turn count 는 2가 된다`() {
        val moveCount = 2
        var count = 0

        val andy = TestCar("Andy")
        val bruce = TestCar("Bruce")

        CarRacing(
            cars = listOf(andy, bruce),
            moveCount = moveCount
        ).run(
            onTurnEnd = { count++ }
        )

        Assertions.assertThat(count).isEqualTo(moveCount)
        Assertions.assertThat(andy.position).isEqualTo(moveCount)
        Assertions.assertThat(bruce.position).isEqualTo(moveCount)
    }
}
