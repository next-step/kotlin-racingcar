package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.strategy.UnconditionalMoveStrategy

class RaceTest {
    @Test
    fun `Car Race Test`() {
        val race = Race()

        race.initiate(5, "car1,car2,car3")
        race.start(UnconditionalMoveStrategy())

        assertThat(race.getCars()).allSatisfy { car: Car ->
            assertThat(car.raceResult).isEqualTo(5)
        }
    }
}
