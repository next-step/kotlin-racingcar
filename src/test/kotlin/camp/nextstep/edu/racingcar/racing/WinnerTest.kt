package camp.nextstep.edu.racingcar.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class WinnerTest {

    @Test
    fun createFromRacingResultTest() {
        val tim = Car(0, "tim", InstantEngine(5))
        val tom = Car(1, "tom", InstantEngine(1))
        val tam = Car(2, "tam", InstantEngine(3))
        val tem = Car(3, "tem", InstantEngine(5))

        val winnersIds = Winner.of(
            mapOf(
                (
                    tim to listOf(
                        CarRaceEvent(10, tim.id, true),
                        CarRaceEvent(20, tim.id, true),
                        CarRaceEvent(30, tim.id, true),
                        CarRaceEvent(40, tim.id, true),
                        CarRaceEvent(50, tim.id, true),
                    )
                    ),
                (
                    tom to listOf(
                        CarRaceEvent(11, tom.id, false),
                        CarRaceEvent(21, tom.id, false),
                        CarRaceEvent(31, tom.id, false),
                        CarRaceEvent(41, tom.id, true),
                        CarRaceEvent(51, tom.id, false),
                    )
                    ),
                (
                    tam to listOf(
                        CarRaceEvent(12, tam.id, false),
                        CarRaceEvent(22, tam.id, true),
                        CarRaceEvent(32, tam.id, true),
                        CarRaceEvent(42, tam.id, false),
                        CarRaceEvent(52, tam.id, true),
                    )
                    ),
                (
                    tem to listOf(
                        CarRaceEvent(13, tem.id, true),
                        CarRaceEvent(23, tem.id, true),
                        CarRaceEvent(33, tem.id, true),
                        CarRaceEvent(43, tem.id, true),
                        CarRaceEvent(53, tem.id, true),
                    )
                    ),
            )
        ).map { it.id }

        assertEquals(2, winnersIds.size)
        assertTrue(winnersIds.contains(tim.id))
        assertTrue(winnersIds.contains(tem.id))
    }
}
