package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.GameProperties

class GameRunnerTest {
    @Test
    fun `사용자가 입력한 수의 자동차가 사용자가 입력한 횟수만큼 전진할 수 있고 이를 저장한다`() {
        val numberOfCars = 5
        val numberOfTrials = 5

        val gameResult = GameRunner(GameProperties(numberOfCars, numberOfTrials))
            .start()
            .gameResult
            .get()

        assertEquals(numberOfTrials, gameResult.size)
        assertEquals(numberOfCars, gameResult[0].get().size)
    }
}