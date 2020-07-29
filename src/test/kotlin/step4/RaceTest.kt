package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `initiate cars test`() {
        val cars = Race.initiate("차1,차2,차3")

        assertThat(cars).hasSize(3)
        assertThat(cars).allSatisfy { car ->
            assertThat(car.name).startsWith("차")
            assertThat(car.raceHistory).isEmpty()
        }
    }

    @Test
    fun `make turn test`() {
        var cars = Race.initiate("차1,차2,차3")

        cars = Race.makeTurn(cars)

        assertThat(cars).allSatisfy { car ->
            assertThat(car.raceHistory[0]).isGreaterThanOrEqualTo(0)
            assertThat(car.raceHistory[0]).isLessThanOrEqualTo(1)
        }
    }

    @Test
    fun `random number area test`() {
        assertThat(Race.getRandomNumber()).isGreaterThan(-1)
        assertThat(Race.getRandomNumber()).isLessThan(10)
    }
}
