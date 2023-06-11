package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `경주 결과`() {
        val condition1 = object : MoveCondition {
            override fun canGoStraight(): Boolean {
                return true
            }
        }
        val car1 = Car(condition1)

        val condition2 = object : MoveCondition {
            override fun canGoStraight(): Boolean {
                return false
            }
        }
        val car2 = Car(condition2)

        val records = Race(listOf(car1, car2), 2).run().records
        assertThat(records[0][0].position).isEqualTo(1)
        assertThat(records[0][1].position).isEqualTo(0)
        assertThat(records[1][0].position).isEqualTo(2)
        assertThat(records[1][1].position).isEqualTo(0)
    }
}
