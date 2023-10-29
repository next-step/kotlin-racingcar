package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameRecorderTest {
    @Test
    fun `자동차의 위치를 기록할 수 있다`() {
        val recorder = RacingGameRecorder()
        val car = Car()
        val carPositions = ArrayList<Int>()

        recorder.record(car)
        carPositions.add(car.position)

        car.tryMove(OnlyTrueMoveCondition())

        recorder.record(car)
        carPositions.add(car.position)

        assertThat(recorder.positionBoard[car]).isEqualTo(CarPositionRecord(carPositions))
    }

    @Test
    fun `여러대의 자동차를 기록할 수 있다`() {
        val recorder = RacingGameRecorder()

        val cars = listOf(Car(), Car())

        cars.forEach { car ->
            recorder.record(car)
        }

        assertThat(recorder.positionBoard.size).isEqualTo(cars.size)
    }
}
