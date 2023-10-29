package study.racingcar

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ResultViewTest {

    private val outputReceiver = mock<OutputReceiver>()

    @Test
    fun `display start title`() {
        val resultView = ResultView(outputReceiver)
        val cars = Cars(listOf(Car(3), Car(1), Car(2)))
        resultView.startDisplayResult()
        resultView.displayRound(cars)
        verify(outputReceiver).receive("---\n-\n--\n")
    }

    @Test
    fun `display cars positions`() {
        val resultView = ResultView(outputReceiver)
        val cars = Cars(listOf(Car(3), Car(1), Car(2)))
        resultView.displayRound(cars)
        verify(outputReceiver).receive("---\n-\n--\n")
    }
}
