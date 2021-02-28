package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.ui.OutputView

class OutputViewTest {

    private val outputView = OutputView()

    @Test
    fun `자동차 진행현황 출력`() {
        assertEquals(outputView.getStringProgress(0), "")
        assertEquals(outputView.getStringProgress(1), "-")
        assertEquals(outputView.getStringProgress(2), "--")
    }
}
