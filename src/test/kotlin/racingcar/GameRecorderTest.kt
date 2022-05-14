package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.MovingStrategy

class GameRecorderTest {
    private val validCarName = "myCar"

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

        val car1 = Car(validCarName, movingStrategy = forwardMovingStrategy)
        val car2 = Car(validCarName, movingStrategy = forwardMovingStrategy)
        val car3 = Car(validCarName, movingStrategy = forwardMovingStrategy)
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

    @Test
    fun `각 횟수별 우승자들의 이름을 가져올 수 있다`() {
        val recorder = GameRecorder()

        val forwardMovingStrategy = object : MovingStrategy {
            override fun tryMove(): Boolean = true
        }
        val noMovingStrategy = object : MovingStrategy {
            override fun tryMove(): Boolean = false
        }

        val winnerCar = Car("win", movingStrategy = forwardMovingStrategy)
        val loserCar = Car("lose", movingStrategy = noMovingStrategy)
        val cars = listOf(winnerCar, loserCar)

        winnerCar.move()
        loserCar.move()
        recorder.record(cars)

        val trialResult = recorder.gameResult.get()[0]

        assertEquals(listOf(winnerCar.name), trialResult.winners)
    }

    @Test
    fun `게임의 우승자들의 이름을 가져올 수 있다`() {
        val recorder = GameRecorder()

        val forwardMovingStrategy = object : MovingStrategy {
            override fun tryMove(): Boolean = true
        }

        val winnerCar1 = Car("win1", movingStrategy = forwardMovingStrategy)
        val winnerCar2 = Car("win2", movingStrategy = forwardMovingStrategy)
        val loserCar = Car("lose", movingStrategy = forwardMovingStrategy)
        val cars = listOf(winnerCar1, winnerCar2, loserCar)

        // first trial
        winnerCar1.move()
        winnerCar2.move()
        loserCar.move()
        recorder.record(cars)

        // second trial
        winnerCar1.move()
        winnerCar2.move()
        recorder.record(cars)

        val gameResult = recorder.gameResult

        assertEquals(listOf(winnerCar1.name, winnerCar2.name), gameResult.winners)
    }
}
