package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import race.model.Car
import race.model.FixedMoveCondition
import race.model.Race

class RaceTest {
    @Test
    fun `경주 결과`() {
        val condition1 = FixedMoveCondition(true)
        val car1 = Car("car1", condition1)

        val condition2 = FixedMoveCondition(false)
        val car2 = Car("car2", condition2)

        val records = Race(listOf(car1, car2), 2).run().records
        assertAll(
            { assertThat(records[0][0].position).isEqualTo(1) },
            { assertThat(records[0][1].position).isEqualTo(0) },
            { assertThat(records[1][0].position).isEqualTo(2) },
            { assertThat(records[1][1].position).isEqualTo(0) }
        )
    }
}
