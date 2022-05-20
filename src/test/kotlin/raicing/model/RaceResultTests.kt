package raicing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceResultTests {
    @Test
    fun `자동차 a, b, c의 위치가 0, 3, 2 인 경우는 우승자가 b 1명이다`() {
        val raceCar = RaceCar(
            Car("a", 0),
            Car("b", 3),
            Car("c", 2),
        )
        val raceResult = RaceResult(raceCar)

        val actual = raceResult.whoIsWinner()
        val expected = listOf(Car(CarInfo("b"), 3))

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `자동차 a, b, c의 위치가 0, 1, 1 인 경우는 우승자가 b, c 2명이다`() {
        val raceCar = RaceCar(
            listOf(
                Car("a", 0),
                Car("b", 1),
                Car("c", 1),
            )
        )
        val raceResult = RaceResult(listOf(raceCar))

        val actual = raceResult.whoIsWinner()
        val expected = listOf(
            Car(CarInfo("b"), 1),
            Car(CarInfo("c"), 1)
        )

        assertThat(actual).isEqualTo(expected)
    }

    private fun RaceCar(vararg cars: Car) = RaceCar(cars.asList())
    private fun RaceResult(vararg raceCars: RaceCar) = RaceResult(raceCars.asList())
    private fun Car(name: String, position: Int = 0) = Car(CarInfo(name), position)
}
