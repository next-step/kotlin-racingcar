package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.data.CarState
import racing.data.RacingGameData
import racing.data.Winners
import racing.domain.random.TestRandomWrapper
import kotlin.random.Random

class RacingGameTest {

    private val testTryCount = 2
    private val testInputCarNames = listOf("pobi", "crong", "honux")
    private val testRacingGameData: RacingGameData = RacingGameData(testInputCarNames, testTryCount)

    @Test
    fun `constructor test`() {
        val racingGame = RacingGame(testRacingGameData, MovementChecker())
        assertThat(racingGame.cars.cars.size).isEqualTo(testInputCarNames.size)
        assertThat(racingGame.cars.cars.map { it.name.value }).containsAll(testInputCarNames)
    }

    @Test
    fun `run test(항상 전진하는 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(4, 10))
        val testRacingGameData = RacingGameData(testInputCarNames, testTryCount)
        val racingGame = RacingGame(testRacingGameData, MovementChecker(randomWrapper))

        val racingGameResult = racingGame.run()

        val racingHistory = racingGameResult.racingHistory
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

        val expectedWinners = Winners(cars.cars.map { it.name })
        assertThat(racingGameResult.winners).isEqualTo(expectedWinners)
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

        val expectedWinners = Winners(cars.cars.map { it.name })
        assertThat(racingGameResult.winners).isEqualTo(expectedWinners)
    }
}
