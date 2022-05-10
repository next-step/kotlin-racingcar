package camp.nextstep.edu.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class RacingTest {

    @DisplayName("10대의 자동차가 각각의 트랙에서 경주를 할 수 있다.")
    @Test
    fun newRacing() {
        val racing = Racing.new(10, 10)

        assertDoesNotThrow {
            racing.start()
        }

        val resultMap = racing.result()
        assertNotNull(resultMap)
        assertEquals(10, resultMap.size)
    }
}
