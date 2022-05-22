package step5.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.model.Car
import racing.model.Race

class RaceTest {
    val cars = listOf(Car.create("pobi"), Car.create("crong"), Car.create("eddi"))

    @Test
    fun `test constructor`() {
        val race = Race(cars, 5)
        Assertions.assertThat(race.cars.size).isEqualTo(3)
    }

    @Test
    fun `test isFinished`() {
        val race = Race(cars, 2)
        Assertions.assertThat(race.isFinished()).isEqualTo(false)
        Assertions.assertThat(race.next().isFinished()).isEqualTo(true)
    }

    @Test
    fun `test next`() {
        val tries = 1000
        val race = (0..99).fold(Race(cars, tries)) { r, _ -> r.next() }
        Assertions.assertThat(race.cars.find { car -> car.position > 10 }).isNotNull
    }

    @Test
    fun `test getWinner`() {
        Assertions.assertThat(
            Race(
                listOf(
                    Car.create("pobi").move().move(),
                    Car.create("crong"),
                    Car.create("eddi").move()
                ),
                0
            ).getWinner().map { it.name }
        ).isEqualTo(listOf("pobi"))

        Assertions.assertThat(
            Race(
                listOf(
                    Car.create("pobi"),
                    Car.create("crong").move(),
                    Car.create("eddi").move()
                ),
                0
            ).getWinner().map { it.name }
        ).isEqualTo(listOf("crong", "eddi"))

        Assertions.assertThatThrownBy { Race(listOf(), 0).getWinner() }
            .isInstanceOf(NoSuchElementException::class.java)
    }
}
