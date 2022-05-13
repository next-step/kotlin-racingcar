package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
        assertThat(cars[0].name).isEqualTo("현대")
        assertThat(cars[1].name).isEqualTo("samsung")
        assertThat(cars[2].name).isEqualTo("L9")
    }

    @Test
    fun `우승자 테스트 a만 우승`() {
        val carRacing = CarRacing()
        val moveCount = 5
        val carA = Car("a").apply { repeat(moveCount) { turnOfPosition.add(5) } }
        val carB = Car("b").apply { repeat(moveCount) { turnOfPosition.add(1) } }
        val carC = Car("c").apply { repeat(moveCount) { turnOfPosition.add(1) } }
        val carD = Car("d").apply { repeat(moveCount) { turnOfPosition.add(2) } }
        val carE = Car("e").apply { repeat(moveCount) { turnOfPosition.add(2) } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: List<String> = carRacing.pickWinners(cars = cars, moveCount = moveCount)
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0]).isEqualTo("a")
    }

    @Test
    fun `우승자 테스트 a, d 우승`() {
        val carRacing = CarRacing()
        val moveCount = 5
        val carA = Car("a").apply { repeat(moveCount) { turnOfPosition.add(5) } }
        val carB = Car("b").apply { repeat(moveCount) { turnOfPosition.add(1) } }
        val carC = Car("c").apply { repeat(moveCount) { turnOfPosition.add(1) } }
        val carD = Car("d").apply { repeat(moveCount) { turnOfPosition.add(5) } }
        val carE = Car("e").apply { repeat(moveCount) { turnOfPosition.add(2) } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: List<String> = carRacing.pickWinners(cars = cars, moveCount = moveCount)
        assertThat(winners.size).isEqualTo(2)
        assertThat(winners[0]).isEqualTo("a")
        assertThat(winners[1]).isEqualTo("d")
    }

    @Test
    fun `우승자 테스트 c, d, e 우승`() {
        val carRacing = CarRacing()
        val moveCount = 5
        val carA = Car("a").apply { repeat(moveCount) { turnOfPosition.add(5) } }
        val carB = Car("b").apply { repeat(moveCount) { turnOfPosition.add(1) } }
        val carC = Car("c").apply { repeat(moveCount) { turnOfPosition.add(6) } }
        val carD = Car("d").apply { repeat(moveCount) { turnOfPosition.add(6) } }
        val carE = Car("e").apply { repeat(moveCount) { turnOfPosition.add(6) } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: List<String> = carRacing.pickWinners(cars = cars, moveCount = moveCount)
        assertThat(winners.size).isEqualTo(3)
        assertThat(winners[0]).isEqualTo("c")
        assertThat(winners[1]).isEqualTo("d")
        assertThat(winners[2]).isEqualTo("e")
    }

    @Test
    fun `우승자 테스트 c만 우승`() {
        val carRacing = CarRacing()
        val moveCount = 5
        val carA = Car("a").apply { repeat(moveCount) { turnOfPosition.add(5) } }
        val carB = Car("b").apply { repeat(moveCount) { turnOfPosition.add(1) } }
        val carC = Car("c").apply { repeat(moveCount) { turnOfPosition.add(6) } }
        val carD = Car("d").apply { repeat(moveCount) { turnOfPosition.add(2) } }
        val carE = Car("e").apply { repeat(moveCount) { turnOfPosition.add(2) } }
        val cars = listOf(carA, carB, carC, carD, carE)

        val winners: List<String> = carRacing.pickWinners(cars = cars, moveCount = moveCount)
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0]).isEqualTo("c")
    }
}
