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

        val racing = Racing(listOf(tim, tom, tam, tem), 5)

        racing.start()

        val winnersIds = racing.winners().map { it.id }

        assertEquals(2, winnersIds.size)
        assertTrue(winnersIds.contains(tim.id))
        assertTrue(winnersIds.contains(tem.id))
    }
}
