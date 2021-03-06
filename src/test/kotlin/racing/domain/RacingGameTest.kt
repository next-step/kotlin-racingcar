package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.data.CarState
import racing.data.RacingGameData
import racing.domain.random.TestRandomWrapper
import kotlin.random.Random

class RacingGameTest {

    private val testTryCount = 2
    private val testInputCarNames = listOf("pobi", "crong", "honux")
    private val testRacingGameData: RacingGameData = RacingGameData(testInputCarNames, testTryCount)
    private val movementChecker = MovementChecker(TestRandomWrapper(9))

    @Test
    fun `constructor test`() {
        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        assertThat(racingGame.cars.cars.size).isEqualTo(testInputCarNames.size)
        assertThat(racingGame.cars.cars.map { it.name.name }).containsAll(testInputCarNames)
    }

    @Test
    fun `run test(항상 전진하는 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(4, 10))
        val testRacingGameData = RacingGameData(testInputCarNames, testTryCount)
        val racingGame = RacingGame(testRacingGameData, MovementChecker(randomWrapper))

        racingGame.run()

        val racingHistory = racingGame.racingHistory
        val firstRoundResult = racingHistory.roundResults[0]
        val secondRoundResult = racingHistory.roundResults[1]

        val cars = racingGame.cars

        assertThat(firstRoundResult.carStates).contains(
            CarState(cars.cars[0].name, CarPosition(1)),
            CarState(cars.cars[1].name, CarPosition(1)),
            CarState(cars.cars[2].name, CarPosition(1))
        )
        assertThat(secondRoundResult.carStates).contains(
            CarState(cars.cars[0].name, CarPosition(2)),
            CarState(cars.cars[1].name, CarPosition(2)),
            CarState(cars.cars[2].name, CarPosition(2))
        )
    }

    @Test
    fun `run test(항상 멈춰있는 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(0, 4))
        val racingGame = RacingGame(testRacingGameData, MovementChecker(randomWrapper))

        val racingGameResult = racingGame.run()

        val racingHistory = racingGameResult.racingHistory
        val firstRoundResult = racingHistory.roundResults[0]
        val secondRoundResult = racingHistory.roundResults[1]

        val cars = racingGame.cars

        assertThat(firstRoundResult.carStates).contains(
            CarState(cars.cars[0].name, CarPosition.INIT_POSITION),
            CarState(cars.cars[1].name, CarPosition.INIT_POSITION),
            CarState(cars.cars[2].name, CarPosition.INIT_POSITION)
        )
        assertThat(secondRoundResult.carStates).contains(
            CarState(cars.cars[0].name, CarPosition.INIT_POSITION),
            CarState(cars.cars[1].name, CarPosition.INIT_POSITION),
            CarState(cars.cars[2].name, CarPosition.INIT_POSITION)
        )
    }

    @Test
    fun `get winner 테스트(winner가 하나)`() {

        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars.cars[0].moveCarIfPossible(movementChecker)
        }

        repeat(3) {
            cars.cars[1].moveCarIfPossible(movementChecker)
        }

        repeat(1) {
            cars.cars[2].moveCarIfPossible(movementChecker)
        }

        assertThat(racingGame.winners.winners).containsOnly(cars.cars[1].name.name)
    }

    @Test
    fun `get winner 테스트(winner가 둘)`() {

        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars.cars[0].moveCarIfPossible(movementChecker)
        }

        repeat(2) {
            cars.cars[1].moveCarIfPossible(movementChecker)
        }

        repeat(1) {
            cars.cars[2].moveCarIfPossible(movementChecker)
        }

        assertThat(racingGame.winners.winners).containsOnly(cars.cars[0].name.name, cars.cars[1].name.name)
    }
}
