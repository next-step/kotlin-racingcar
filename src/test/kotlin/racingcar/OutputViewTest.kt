package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OutputViewTest {

    private val outputView = OutputView()

    @Test
    fun `자동차 진행현황 출력`() {
        assertEquals(outputView.printCurrentPosition(0), "")
        assertEquals(outputView.printCurrentPosition(1), "-")
        assertEquals(outputView.printCurrentPosition(2), "--")
    }
}