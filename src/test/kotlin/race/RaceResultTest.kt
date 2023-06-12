package race

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import race.domain.Car
import race.domain.FixedMoveCondition
import race.domain.Race

class RaceResultTest {
    @Test
    fun `우승자는 car1과 car3`() {
        val trueCondition = FixedMoveCondition(true)
        val car1 = Car("car1", trueCondition)

        val falseCondition = FixedMoveCondition(false)
        val car2 = Car("car2", falseCondition)

        val car3 = Car("car3", trueCondition)

        val raceResult = Race().run(listOf(car1, car2, car3), 2)
        val winners = raceResult.findWinners()
        Assertions.assertThat(winners[0].name).isEqualTo("car1")
        Assertions.assertThat(winners[1].name).isEqualTo("car3")
    }
}
