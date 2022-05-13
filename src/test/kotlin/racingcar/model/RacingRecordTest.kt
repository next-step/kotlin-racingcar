package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.model.movement.AlwaysGoMovement

internal class RacingRecordTest {

    @Test
    internal fun testForWriteRecord() {

        // given
        val carA = Car("id_A", AlwaysGoMovement(), "name_A")
        val carB = Car("id_B", AlwaysGoMovement(), "name_B")
        val racingRecord = RacingRecord(listOf(carA, carB))

        // when
        repeat(3) {
            carA.moveIfItCan()
            racingRecord.writeRecord(carA) // move 3 times
        }

        repeat(2) {
            carB.moveIfItCan()
            racingRecord.writeRecord(carB) // move 2 times
        }

        // then
        assertAll(
            {
                assertThat(racingRecord.stepToTry).isEqualTo(3)
            },
            {
                assertThat(racingRecord.winnersRecord.joinToString { it.car.carName })
                    .isEqualTo("name_A") // A is the winner
            },
            {
                assertThat(racingRecord.latestRecord.joinToString(","))
                    .isEqualTo("3,2")
            }

        )
    }
}
