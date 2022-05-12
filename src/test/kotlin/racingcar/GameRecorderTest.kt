package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.MovingCar

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

        val car1 = MovingCar()
        val car2 = MovingCar()
        val car3 = MovingCar()

        val carsAfterFirstTrial = listOf(Car(car1.moveAndReturn()), Car(car2.moveAndReturn()), Car(car3))
        val carsAfterSecondTrial = listOf(Car(car1), Car(car2.moveAndReturn()), Car(car3.moveAndReturn()))

        recorder.record(carsAfterFirstTrial)
        recorder.record(carsAfterSecondTrial)

        val gameResult = recorder.gameResult.get()

        assertEquals(2, gameResult.size)
        assertEquals(TrialResult(carsAfterFirstTrial), gameResult[0])
        assertEquals(TrialResult(carsAfterSecondTrial), gameResult[1])
    }
}
