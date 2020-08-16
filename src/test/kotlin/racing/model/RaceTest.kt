package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.strategy.UnconditionalMoveStrategy

class RaceTest {
    @Test
    fun `Car Race Test`() {
        val race = Race(5, "car1,car2,car3")
        val strategy = UnconditionalMoveStrategy()
        race.run(strategy)

        race.cars[0].saveResultOfTurn(4)

        assertThat(race.cars).allSatisfy { car: Car ->
            assertThat(car.takeRaceHistory(6)).isEqualTo(5)
        }
    }
}
