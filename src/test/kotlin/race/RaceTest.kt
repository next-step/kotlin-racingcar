package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import race.domain.Car
import race.domain.FixedMoveCondition
import race.domain.Race

class RaceTest {
    @Test
    fun `경주 결과`() {
        val condition1 = FixedMoveCondition(true)
        val car1 = Car("car1", condition1)

        val condition2 = FixedMoveCondition(false)
        val car2 = Car("car2", condition2)

        val records = Race().run(listOf(car1, car2), 3).records
        assertAll(
            { assertThat(records[0][0].position).isEqualTo(1) },
            { assertThat(records[0][1].position).isEqualTo(0) },
            { assertThat(records[1][0].position).isEqualTo(2) },
            { assertThat(records[1][1].position).isEqualTo(0) },
            { assertThat(records[2][0].position).isEqualTo(3) },
            { assertThat(records[2][1].position).isEqualTo(0) }
        )
    }
}
