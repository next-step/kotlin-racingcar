package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingCarsTest {
    @Test
    fun `create RacingCars`() {
        val racingCars = RacingCars.fromNames(listOf("pobi", "jason", "anna"))
        Assertions.assertThat(racingCars).isEqualTo(
            RacingCars(
                listOf(RacingCar("pobi"), RacingCar("jason"), RacingCar("anna"))
            )
        )
    }
}
