package step4

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `initiate cars test`() {
        val cars = Race.initiate("차1,차2,차3")

        assertThat(cars.size == 3)
        AssertionsForInterfaceTypes.assertThat(cars).allSatisfy { car ->
            AssertionsForInterfaceTypes.assertThat(car.name).startsWith("차")
            AssertionsForInterfaceTypes.assertThat(car.raceResult).isEmpty()
        }
    }
}
