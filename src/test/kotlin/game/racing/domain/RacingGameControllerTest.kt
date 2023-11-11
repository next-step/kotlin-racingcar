package game.racing.domain

import game.racing.controller.RacingGameController
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameControllerTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5])
    fun `반복횟수만큼 게임을 진행하고, 모든 라운드의 결과를 반환한다`(repeatCount: Int) {
        // given
        val racingGameController = RacingGameController(RacingManager(listOf(Car("TEST1"), Car("TEST2"), Car("TEST3"))))

        // when
        val gameResult = racingGameController.tryMovesRepeatedly(repeatCount)

        // then
        assert(gameResult.size == repeatCount)
    }
}
