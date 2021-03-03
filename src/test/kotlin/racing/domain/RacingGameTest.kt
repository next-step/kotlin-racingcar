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
    private val testCarNames = listOf(CarName("pobi"), CarName("crong"), CarName("honux"))
    private val testRacingGameData: RacingGameData = RacingGameData(testInputCarNames, testTryCount)

    @Test
    fun `constructor test`() {
        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        assertThat(racingGame.cars.cars.size).isEqualTo(testInputCarNames.size)
        assertThat(racingGame.cars.cars.map { it.name }).containsAll(testCarNames)
    }

    @Test
    fun `run test(항상 전진하는 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(4, 10))
        val testRacingGameData: RacingGameData = RacingGameData(testInputCarNames, testTryCount)
        val racingGame = RacingGame(testRacingGameData, MovementChecker(randomWrapper))

        val racingHistory = racingGame.run()

        val firstRoundResult = racingHistory.roundResults[0]
        val secondRoundResult = racingHistory.roundResults[1]

        assertThat(firstRoundResult.carStates).contains(
            CarState(testCarNames[0], CarPosition(1)),
            CarState(testCarNames[1], CarPosition(1)),
            CarState(testCarNames[2], CarPosition(1))
        )
        assertThat(secondRoundResult.carStates).contains(
            CarState(testCarNames[0], CarPosition(2)),
            CarState(testCarNames[1], CarPosition(2)),
            CarState(testCarNames[2], CarPosition(2))
        )
    }

    @Test
    fun `run test(항상 멈춰있는 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(0, 4))
        val racingGame = RacingGame(testRacingGameData, MovementChecker(randomWrapper))

        val racingHistory = racingGame.run()

        val firstRoundResult = racingHistory.roundResults[0]
        val secondRoundResult = racingHistory.roundResults[1]

        assertThat(firstRoundResult.carStates).contains(
            CarState(testCarNames[0], CarPosition.INIT_POSITION),
            CarState(testCarNames[1], CarPosition.INIT_POSITION),
            CarState(testCarNames[2], CarPosition.INIT_POSITION)
        )
        assertThat(secondRoundResult.carStates).contains(
            CarState(testCarNames[0], CarPosition.INIT_POSITION),
            CarState(testCarNames[1], CarPosition.INIT_POSITION),
            CarState(testCarNames[2], CarPosition.INIT_POSITION)
        )
    }

    @Test
    fun `get winner 테스트(winner가 하나)`() {

        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars.cars[0].moveCar()
        }

        repeat(3) {
            cars.cars[1].moveCar()
        }

        repeat(1) {
            cars.cars[2].moveCar()
        }

        assertThat(racingGame.getWinnerNames()).containsOnly(cars.cars[1].name.name)
    }

    @Test
    fun `get winner 테스트(winner가 둘)`() {

        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars.cars[0].moveCar()
        }

        repeat(2) {
            cars.cars[1].moveCar()
        }

        repeat(1) {
            cars.cars[2].moveCar()
        }

        assertThat(racingGame.getWinnerNames()).containsOnly(cars.cars[0].name.name, cars.cars[1].name.name)
    }
}
