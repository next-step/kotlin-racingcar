package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.GameProperties

class GameRunnerTest {
    @Test
    fun `사용자가 입력한 이름을 가진 자동차가 사용자가 입력한 횟수만큼 전진할 수 있고 이를 저장한다`() {
        val namesOfCars = listOf("car1", "car2", "car3")
        val numberOfTrials = 5

        val gameResult = GameRunner(GameProperties(namesOfCars, numberOfTrials))
            .start()
            .get()

        assertEquals(numberOfTrials, gameResult.size)
        assertEquals(namesOfCars.size, gameResult[0].get().size)
    }
}
