package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.domain.CarRacing
import racing.dto.Car
import racing.dto.Winners

class CarRacingTest {
    @Test
    fun `차 리스트 생성하고 차 리스트에 각자 이름이 제대로 들어간다`() {
        val carRacing = CarRacing()
        carRacing.createCars(listOf("현대", "samsung", "L9"))

        assertThat(carRacing.cars).containsExactlyInAnyOrder(Car("현대"), Car("samsung"), Car("L9"))
    }

    @Test
    fun `우승자 테스트 a만 우승`() {
        val carA = Car("a", startPosition = 2)
        val carB = Car("b", startPosition = 1)
        val carC = Car("c", startPosition = 1)
        val carD = Car("d", startPosition = 1)
        val carE = Car("e", startPosition = 1)
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners = Winners(cars = cars).pickWinners()
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0].name).isEqualTo("a")
    }

    @Test
    fun `우승자 테스트 a, d 우승`() {
        val carA = Car("a", startPosition = 3)
        val carB = Car("b", startPosition = 1)
        val carC = Car("c", startPosition = 1)
        val carD = Car("d", startPosition = 3)
        val carE = Car("e", startPosition = 2)
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners = Winners(cars = cars).pickWinners()
        assertThat(winners.size).isEqualTo(2)
        assertThat(winners[0].name).isEqualTo("a")
        assertThat(winners[1].name).isEqualTo("d")
    }

    @Test
    fun `우승자 테스트 c, d, e 우승`() {
        val carA = Car("a", startPosition = 2)
        val carB = Car("b", startPosition = 1)
        val carC = Car("c", startPosition = 3)
        val carD = Car("d", startPosition = 3)
        val carE = Car("e", startPosition = 3)
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners = Winners(cars = cars).pickWinners()
        assertThat(winners.size).isEqualTo(3)
        assertThat(winners[0].name).isEqualTo("c")
        assertThat(winners[1].name).isEqualTo("d")
        assertThat(winners[2].name).isEqualTo("e")
    }

    @Test
    fun `우승자 테스트 c만 우승`() {
        val carA = Car("a", startPosition = 3)
        val carB = Car("b", startPosition = 1)
        val carC = Car("c", startPosition = 4)
        val carD = Car("d", startPosition = 2)
        val carE = Car("e", startPosition = 2)
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners = Winners(cars = cars).pickWinners()
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0].name).isEqualTo("c")
    }

    @Test
    fun `차 이름이 5글자를 초과하여 IllegalStateException을 발생시킨다`() {
        assertThrows<IllegalStateException> {
            CarRacing().checkCarNameLength("나비보벳따우")
        }
    }
}
