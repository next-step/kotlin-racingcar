package study.racingcar.view

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ResultViewTest {

    private val outputReceiver = mock<OutputReceiver>()

    @Test
    fun `display start title`() {
        val resultView = ResultView(outputReceiver)
        resultView.startDisplayResult()
        verify(outputReceiver).receive("실행 결과")
    }

    @Test
    fun `display cars positions`() {
        val resultView = ResultView(outputReceiver)
        val carPositions = listOf(
            "hong" to 3,
            "lee" to 1,
            "kim" to 2
        )
        resultView.displayRound(carPositions)
        verify(outputReceiver).receive("hong : ---\nlee : -\nkim : --\n")
    }

    @Test
    fun `display winners`() {
        val resultView = ResultView(outputReceiver)
        val winnerNames = listOf("hong", "lee", "kim")
        resultView.displayWinners(winnerNames)
        verify(outputReceiver).receive("hong, lee, kim 가 최종 우승했습니다.")
    }
}
