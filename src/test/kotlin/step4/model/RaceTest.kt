package step4.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.model.Car
import step4.model.Race
import step4.strategy.UnconditionalMoveStrategy

class RaceTest {
    @Test
    fun `Car Race Test`() {
        val race = Race("car1,car2,car3")

        repeat(5) {
            race.makeTurn(UnconditionalMoveStrategy())
        }

        assertThat(race.getCars()).allSatisfy { car: Car ->
            assertThat(car.raceResult).isEqualTo(5)
        }
    }
}
