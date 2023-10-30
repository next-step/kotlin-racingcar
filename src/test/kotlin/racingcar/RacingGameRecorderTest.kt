package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameRecorderTest {
    @Test
    fun `자동차의 위치를 기록할 수 있다`() {
        val recorder = RacingGameRecorder()
        val car = Car(OnlyTrueMoveCondition())
        val cars = listOf(car)
        val carPositions = ArrayList<CarPositionRecord>()

        recorder.recordRound(cars)
        carPositions.add(CarPositionRecord(car.name, car.position))

        car.tryMove()

        recorder.recordRound(cars)
        carPositions.add(CarPositionRecord(car.name, car.position))

        val actual = recorder.gameResultRecord.raceResults.map { it.carPositions.first() }

        assertThat(actual).isEqualTo(carPositions)
    }

    @Test
    fun `여러대의 자동차를 기록할 수 있다`() {
        val recorder = RacingGameRecorder()

        val cars = listOf(
            Car(OnlyTrueMoveCondition()),
            Car(OnlyTrueMoveCondition()),
        )

        recorder.recordRound(cars)

        val recordedCarSize = recorder.gameResultRecord.raceResults.first().carPositions.size

        assertThat(recordedCarSize).isEqualTo(cars.size)
    }

    @Test
    fun `우승자를 기록하지 않으면 우승자가 존재하지 않는다`() {
        val recorder = RacingGameRecorder()

        assertThrows<IllegalStateException> {
            recorder.gameResultRecord.winners
        }
    }

    @Test
    fun `우승자를 기록하면 gameResultRecord에 우승자가 남는다`() {
        val recorder = RacingGameRecorder()

        recorder.recordRound(listOf(Car(OnlyTrueMoveCondition(), "a")))

        assertThat(recorder.gameResultRecord.winners).isEqualTo(Winners(listOf("a")))
    }
}
