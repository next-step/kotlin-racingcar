package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.GameProperties

class GameRunnerTest {
    private val namesOfCars = listOf("car1", "car2", "car3")
    private val numberOfTrials = 5

    private val gameResult = GameRunner(GameProperties(namesOfCars, numberOfTrials))
        .start()
        .get()

    @Test
    fun `자동차는 사용자가 입력한 횟수만큼 전진할 수 있고 처음 위치와 같이 게임 결과가 저장된다`() {
        assertEquals(numberOfTrials + 1, gameResult.size)
    }

    @Test
    fun `사용자가 지정한 이름을 가진 자동차들이 경주를 참가하고 게임 결과에 저장된다`() {
        assertEquals(namesOfCars.size, gameResult[0].get().size)
        assertEquals(namesOfCars, gameResult[0].get().map { it.name })
    }
}
