package racingcar.game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.game.ui.InputConsole

internal class GameTest {
    private lateinit var carNameReader: () -> String?
    private lateinit var numOfGameReader: () -> String?

    @Test
    fun `모두 움직이지 않는 경우 게임 실행 테스트`() {
        // given
        carNameReader = { "name1,name2,name3" }
        numOfGameReader = { "3" }

        // when
        val param = InputConsole(carNameReader, numOfGameReader).run()
        val moveCondition = { 1 }
        val result = Game(param, moveCondition).start()

        // then
        val lastRoundHistory: List<Car> = result.history.last().roundHistory
        assertThat(result.history.size).isEqualTo(3)
        assertThat(lastRoundHistory)
            .extracting("position")
            .containsOnly(0)
    }

    @Test
    fun `모두 움직이는 경우 게임 실행 테스트`() {
        // given
        carNameReader = { "name1,name2,name3" }
        numOfGameReader = { "3" }

        // when
        val param = InputConsole(carNameReader, numOfGameReader).run()
        val moveCondition = { 6 }
        val result = Game(param, moveCondition).start()

        // then
        val lastRoundHistory: List<Car> = result.history.last().roundHistory
        assertThat(result.history.size).isEqualTo(3)
        assertThat(lastRoundHistory)
            .extracting("position")
            .containsOnly(3)
    }
}
