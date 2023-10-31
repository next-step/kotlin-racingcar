package race.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.Mockito.mock
import race.ui.ResultView

class RacingTest {
    private val alwaysGo = { true }
    private val alwaysStop = { false }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1, 3",
            "2, 4",
            "3, 5"
        ]
    )
    fun `경주를 진행하면 시도 횟수만큼 차량이 전진`(numberOfCar: Int, round: Int) {
        val mockedReviewView = mock<ResultView>()
        val racingCarList = List(numberOfCar) { RacingCar(name = "$it") }

        Racing(
            racingCarList = racingCarList,
            round = round,
            goRule = alwaysGo,
            resultView = mockedReviewView,
        ).startRace()

        racingCarList.forEach {
            assertEquals(round, it.space)
            assertEquals(true, it.isWinner)
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1, 3",
            "2, 4",
            "3, 5"
        ]
    )
    fun `경주를 진행하면 모든 차량이 정지`(numberOfCar: Int, round: Int) {
        val mockedReviewView = mock<ResultView>()
        val racingCarList = List(numberOfCar) { RacingCar(name = "$it") }

        Racing(
            racingCarList = racingCarList,
            round = round,
            goRule = alwaysStop,
            resultView = mockedReviewView,
        ).startRace()

        racingCarList.forEach {
            assertEquals(0, it.space)
            assertEquals(true, it.isWinner)
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1, -3",
            "2, -4",
            "3, -5"
        ]
    )
    fun `시도 횟수가 음수인 경우 에러 발생`(numberOfCar: Int, round: Int) {
        val mockedReviewView = mock<ResultView>()
        val racingCarList = List(numberOfCar) { RacingCar(name = "$it") }

        Assertions.assertThatThrownBy {
            Racing(
                racingCarList = racingCarList,
                round = round,
                goRule = alwaysGo,
                resultView = mockedReviewView,
            ).startRace()
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("Must be at least one round!")
    }
}
