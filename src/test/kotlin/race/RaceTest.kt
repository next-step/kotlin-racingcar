package race

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import race.domain.Car
import race.domain.Race
import kotlin.random.Random

class RaceTest {

    @Test
    fun `illegal lap count test`() {

        // GIVEN
        val cars = Car.create("pobi,crong")
        val lapCount = -5

        // WHEN
        val race = Race(cars)
        Assertions
            .assertThatThrownBy {
                race.start(lapCount) { Random.nextInt(Car.MOVE_START_RANGE, Car.MOVE_END_RANGE) }
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("lap count is positive.")
    }

    @Test
    fun `start race not move test`() {

        // GIVEN
        val carNames = "pobi,crong"
        val lapCount = 5

        // WHEN
        val race = Race(Car.create(carNames))
            .start(lapCount) { 2 }

        // THEN
        assertThat(race).isNotNull

        race.cars.forEach {
            assertThat(it.name).isIn(carNames.split(Car.NAME_DELIMETER))
            assertThat(it.position).isEqualTo(0)
        }
    }

    @Test
    fun `start race move test`() {

        // GIVEN
        val carNames = "pobi,crong"
        val lapCount = 5

        // WHEN
        val race = Race(Car.create(carNames))
            .start(lapCount) { 7 }

        // THEN
        assertThat(race).isNotNull
        assertThat(race.cars.size).isEqualTo(2)

        race.cars.forEach {
            assertThat(it.name).isIn(carNames.split(Car.NAME_DELIMETER))
            assertThat(it.position).isEqualTo(5)
        }
    }

    @Test
    fun `start and take winner test`() {

        // GIVEN
        val carNames = "pobi,crong"
        val lapCount = 3

        // WHEN
        val winners = Race(Car.create(carNames))
            .start(lapCount) { 7 }
            .takeWinners()

        // THEN
        assertThat(winners.size).isEqualTo(2)
        winners.forEach {
            assertThat(it.name).isIn(carNames.split(Car.NAME_DELIMETER))
            assertThat(it.position).isEqualTo(3)
        }
    }

    @Test
    fun `take winner test`() {

        // GIVEN
        val pobi = Car("pobi")
        val crong = Car("crong")
        pobi.move(4)
        pobi.move(4)
        pobi.move(4)
        crong.move(4)
        crong.move(4)


        // WHEN
        val winners = Race(listOf(pobi, crong))
            .takeWinners()

        // THEN
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0].name).isEqualTo("pobi")
        assertThat(winners[0].position).isEqualTo(3)
    }
}
