package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.ui.OutputView

class OutputViewTest {

    private val outputView = OutputView()

    @Test
    fun `자동차 진행현황 출력`() {
        assertEquals(outputView.getCurrentProgress(0), "")
        assertEquals(outputView.getCurrentProgress(1), "-")
        assertEquals(outputView.getCurrentProgress(2), "--")
    }
}
