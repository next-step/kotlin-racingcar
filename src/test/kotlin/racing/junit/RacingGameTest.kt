package racing.junit

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.any
import racing.condition.FirstRoundCondition
import racing.condition.RacingCondition
import racing.condition.RandomCondition
import racing.model.Car
import racing.model.RacingGame
import racing.view.result.BasicCarResultView

class RacingGameTest {
    @Test
    fun `startRacing 성공`() {
        // given
        val cars = listOf(Car(), Car())
        val totalRound = 3
        val conditions = listOf(FirstRoundCondition())
        val carResultView = BasicCarResultView()
        val mockRacingGame = makeMockRacingGame(cars, totalRound, conditions)

        // when
        mockRacingGame.startRacing(carResultView)

        // then
        verify(mockRacingGame).startRound(1, carResultView)
        verify(mockRacingGame).startRound(2, carResultView)
        verify(mockRacingGame).startRound(3, carResultView)
        verify(mockRacingGame, times(3)).startRound(any(), any())
    }

    @Test
    fun `startRound 성공`() {
        // given
        val totalRound = 3
        val conditions = listOf(FirstRoundCondition())
        val carResultView = BasicCarResultView()

        val mockCar1 = makeMockCar()
        val mockCar2 = makeMockCar()
        val cars = listOf(mockCar1, mockCar2)

        val mockClass = makeMockRacingGame(cars, totalRound, conditions)

        // when
        mockClass.startRound(1, carResultView)

        // then
        verify(mockCar1).doRacing(1, conditions)
        verify(mockCar2).doRacing(1, conditions)
    }

    @Test
    fun `레이싱 게임 테스트`() {
        // given
        val carCount = 3
        val totalRound = 5

        val conditions = listOf(FirstRoundCondition(), RandomCondition())

        val racingGame = RacingGame(carCount, totalRound, conditions)

        // when
        racingGame.startRacing(BasicCarResultView())

        // then
    }

    private fun makeMockRacingGame(cars: List<Car>, round: Int, conditions: List<RacingCondition>): RacingGame {
        return mock(
            RacingGame::class.java,
            Mockito.withSettings().useConstructor(cars, round, conditions)
                .defaultAnswer(Mockito.CALLS_REAL_METHODS),
        )
    }

    private fun makeMockCar(): Car {
        return mock(Car::class.java)
    }
}
