package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.MovingStrategy

class GameRecorderTest {
    @Test
    fun `게임이 진행되지 않았을 경우 result 는 비어있다`() {
        val recorder = GameRecorder()
        val gameResult = recorder.gameResult.get()

        assertEquals(0, gameResult.size)
    }

    @Test
    fun `게임이 진행될 경우 각 횟수별 자동차들의 위치를 저장한다`() {
        val recorder = GameRecorder()
        val forwardMovingStrategy = object : MovingStrategy {
            override fun tryMove(): Boolean = true
        }

        val car1 = Car(movingStrategy = forwardMovingStrategy)
        val car2 = Car(movingStrategy = forwardMovingStrategy)
        val car3 = Car(movingStrategy = forwardMovingStrategy)
        val cars = listOf(car1, car2, car3)

        // first trial
        car1.move()
        car2.move()
        recorder.record(cars)
        val expectedFirstTrialResult = TrialResult(listOf(CarResult(car1), CarResult(car2), CarResult(car3)))

        // second trial
        car2.move()
        car3.move()
        recorder.record(cars)
        val expectedSecondTrialResult = TrialResult(listOf(CarResult(car1), CarResult(car2), CarResult(car3)))

        val gameResult = recorder.gameResult.get()

        assertEquals(2, gameResult.size)
        assertEquals(expectedFirstTrialResult, gameResult[0])
        assertEquals(expectedSecondTrialResult, gameResult[1])
    }
}
