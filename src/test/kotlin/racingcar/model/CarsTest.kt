package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.impl.CarsImpl

internal class CarsTest {
    @Test
    internal fun `자동차 위치가 증가한다`() {
        val car1 = Car.of("pobi", 10)
        val car2 = Car.of("crong", 100)
        val cars = CarsImpl(listOf(car1, car2))
        cars.move { -> MoveFactor(4) }
        assertThat(car1.position.value).isEqualTo(11)
        assertThat(car2.position.value).isEqualTo(101)
    }

    @Test
    internal fun `선두에 있는 차를 선정한다`() {
        val winner = Car.of("win", 10)
        val loser = Car.of("lose", 9)
        val cars = listOf(winner, loser)
        val racingGame = CarsImpl(cars)

        val carsInLead = racingGame.carsInLead()

        assertThat(carsInLead.value.size).isEqualTo(1)
        assertThat(carsInLead.value.first().name).isEqualTo(winner.name)
    }

    @Test
    internal fun `선두가 2명 이상일 경우`() {
        val p1 = Car.of("pobi", 10)
        val p2 = Car.of("crong", 10)
        val p3 = Car.of("honux", 9)
        val cars = CarsImpl(listOf(p1, p2, p3))

        val carsInLead = cars.carsInLead()
        val expectedCars = listOf(p1, p2)

        assertThat(carsInLead.value).containsExactlyInAnyOrderElementsOf(expectedCars)
    }
}
