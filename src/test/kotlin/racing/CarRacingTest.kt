package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.domain.CarRacing
import racing.dto.Car
import racing.dto.Winners
import racing.view.CarRacingInputView

class CarRacingTest {
    @Test
    fun `레이싱을 해본다`() {
        val carRacing = CarRacing()
        carRacing.moveCars(cars = listOf(Car("현대"), Car("KIA"), Car("SAMSUNG")), moveCount = 5)
    }

    @Test
    fun `차 리스트 생성하고 차 리스트에 각자 이름이 제대로 들어간다`() {
        val carRacing = CarRacing()
        val cars: List<Car> = carRacing.createCars(listOf("현대", "samsung", "L9"))

        assertThat(cars).containsExactlyInAnyOrder(Car("현대"), Car("samsung"), Car("L9"))
    }

    @Test
    fun `우승자 테스트 a만 우승`() {
        val carRacing = CarRacing()
        val carA = Car("a").also { it.go { 2 } }
        val carB = Car("b").also { it.go { 1 } }
        val carC = Car("c").also { it.go { 1 } }
        val carD = Car("d").also { it.go { 1 } }
        val carE = Car("e").also { it.go { 1 } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: Winners = carRacing.pickWinners(cars = cars)
        assertThat(winners.winnerNames.size).isEqualTo(1)
        assertThat(winners.winnerNames[0]).isEqualTo("a")
    }

    @Test
    fun `우승자 테스트 a, d 우승`() {
        val carRacing = CarRacing()
        val carA = Car("a").also { it.go { 3 } }
        val carB = Car("b").also { it.go { 1 } }
        val carC = Car("c").also { it.go { 1 } }
        val carD = Car("d").also { it.go { 3 } }
        val carE = Car("e").also { it.go { 2 } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: Winners = carRacing.pickWinners(cars = cars)
        assertThat(winners.winnerNames.size).isEqualTo(2)
        assertThat(winners.winnerNames[0]).isEqualTo("a")
        assertThat(winners.winnerNames[1]).isEqualTo("d")
    }

    @Test
    fun `우승자 테스트 c, d, e 우승`() {
        val carRacing = CarRacing()
        val carA = Car("a").also { it.go { 2 } }
        val carB = Car("b").also { it.go { 1 } }
        val carC = Car("c").also { it.go { 3 } }
        val carD = Car("d").also { it.go { 3 } }
        val carE = Car("e").also { it.go { 3 } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: Winners = carRacing.pickWinners(cars = cars)
        assertThat(winners.winnerNames.size).isEqualTo(3)
        assertThat(winners.winnerNames[0]).isEqualTo("c")
        assertThat(winners.winnerNames[1]).isEqualTo("d")
        assertThat(winners.winnerNames[2]).isEqualTo("e")
    }

    @Test
    fun `우승자 테스트 c만 우승`() {
        val carRacing = CarRacing()
        val carA = Car("a").also { it.go { 3 } }
        val carB = Car("b").also { it.go { 1 } }
        val carC = Car("c").also { it.go { 4 } }
        val carD = Car("d").also { it.go { 2 } }
        val carE = Car("e").also { it.go { 2 } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: Winners = carRacing.pickWinners(cars = cars)
        assertThat(winners.winnerNames.size).isEqualTo(1)
        assertThat(winners.winnerNames[0]).isEqualTo("c")
    }

    @Test
    fun `차 이름이 5글자를 초과하여 IllegalStateException을 발생시킨다`() {
        assertThrows<IllegalStateException> {
            CarRacingInputView.checkCarNameLength("나비보벳따우")
        }
    }
}
