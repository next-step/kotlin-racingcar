package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `initiate cars test`() {
        val cars = Race.initiate("차1,차2,차3")

        assertThat(cars.size == 3)
        assertThat(cars).allSatisfy { car ->
            assertThat(car.name).startsWith("차")
            assertThat(car.raceResult).isEmpty()
        }
    }

    @Test
    fun `random number area test`() {
        assertThat(Race.getRandomNumber()).isGreaterThan(-1)
        assertThat(Race.getRandomNumber()).isLessThan(10)
    }

    @Test
    fun `successToMove test`() {
        assertThat(Race.successToMove(2)).isEqualTo(0)
        assertThat(Race.successToMove(8)).isEqualTo(1)
    }
}
