package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import racingcar.strategy.RandomStrategy
import racingcar.ui.InputView
import racingcar.ui.ResultView
import java.util.function.Consumer

class RacingGameManagerTest {

    val inputView = mock(InputView::class.java)

    val resultView = mock(ResultView::class.java)

    @Test
    fun `RacingGameManager test`() {

        Mockito.`when`(inputView.numOfCar).thenReturn(3)
        Mockito.`when`(inputView.numOfRepetition).thenReturn(5)

        val racingGameManager = RacingGameManager.builder(inputView, resultView)
            .strategy(RandomStrategy())
            .build()

        assertThat(racingGameManager).isNotNull

        // TODO 어떤식으로 테스트 하면 좋을까 고민해보기
        racingGameManager.racing(Consumer { racingGameManager.showRacingResult() })
    }
}
