package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test
import racing.data.RacingGameData
import racing.domain.random.TestRandomWrapper
import kotlin.random.Random

class RacingGameTest {

    private val testTryCount = 2
    private val testCarNames = listOf("pobi", "crong", "honux")
    private val testRacingGameData: RacingGameData = RacingGameData(testCarNames, testTryCount)

    @Test
    fun `constructor test`() {
        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        assertThat(racingGame.cars.size).isEqualTo(testCarNames.size)
        assertThat(racingGame.cars).extracting("name").containsAll(testCarNames)
    }

    @Test
    fun `run test(항상 전진하는 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(4, 10))
        val racingGame = RacingGame(testRacingGameData, MovementChecker(randomWrapper))

        val racingHistory = racingGame.run()

        val racingStateOfFirstRound = racingHistory.racingStates[0]
        val racingStateOfSecondRound = racingHistory.racingStates[1]

        assertThat(racingStateOfFirstRound.carPositions).contains(
            entry(testCarNames[0], 1), entry(testCarNames[1], 1), entry(testCarNames[2], 1)
        )
        assertThat(racingStateOfSecondRound.carPositions).contains(
            entry(testCarNames[0], 2), entry(testCarNames[1], 2), entry(testCarNames[2], 2)
        )
    }

    @Test
    fun `run test(항상 멈춰있는 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(0, 4))
        val racingGame = RacingGame(testRacingGameData, MovementChecker(randomWrapper))

        val racingHistory = racingGame.run()

        val racingStateOfFirstRound = racingHistory.racingStates[0]
        val racingStateOfSecondRound = racingHistory.racingStates[1]

        assertThat(racingStateOfFirstRound.carPositions).contains(
            entry(testCarNames[0], 0), entry(testCarNames[1], 0), entry(testCarNames[2], 0)
        )
        assertThat(racingStateOfSecondRound.carPositions).contains(
            entry(testCarNames[0], 0), entry(testCarNames[1], 0), entry(testCarNames[2], 0)
        )
    }

    @Test
    fun `get winner 테스트(winner가 하나)`() {

        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars[0].moveCar()
        }

        repeat(3) {
            cars[1].moveCar()
        }

        repeat(1) {
            cars[2].moveCar()
        }

        assertThat(racingGame.getWinners()).containsOnly(cars[1])
    }

    @Test
    fun `get winner 테스트(winner가 둘)`() {

        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars[0].moveCar()
        }

        repeat(2) {
            cars[1].moveCar()
        }

        repeat(1) {
            cars[2].moveCar()
        }

        assertThat(racingGame.getWinners()).containsOnly(cars[0], cars[1])
    }
}
