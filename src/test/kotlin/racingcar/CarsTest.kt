package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.CarFixtures.createAlwaysMovingCar
import racingcar.CarFixtures.createCanNotMovingCar

internal class CarsTest {
    @Test
    fun `우승자가 한명 일 때`() {
        val winner = createAlwaysMovingCar()
        val cars: Cars = Cars(
            listOf(
                winner,
                createCanNotMovingCar(),
                createCanNotMovingCar()
            )
        )
        cars.proceedOneTurn()

        assertThat(cars.winner()).isEqualTo(listOf(winner))
    }

    @Test
    fun `우승자가 2명 일 때`() {
        val winner1 = createAlwaysMovingCar()
        val winner2 = createAlwaysMovingCar()
        val cars: Cars = Cars(
            listOf(
                winner1,
                createCanNotMovingCar(),
                createCanNotMovingCar(),
                winner2
            )
        )
        cars.proceedOneTurn()

        val winners = cars.winner()
        assertAll(
            "Should return address of Oracle's headquarter",
            { assertEquals(2, winners.size) },
            { assertThat(cars.winner().containsAll(listOf(winner1, winner2))).isTrue() }
        )
    }
}
