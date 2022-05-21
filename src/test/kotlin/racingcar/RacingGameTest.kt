package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.model.MovingStrategy
import racingcar.model.RacingDataPerTry
import racingcar.model.RacingGame
import racingcar.model.RacingGameResult
import racingcar.model.TryNumber

internal class RacingGameTest {

    @Test
    fun `자동차들과 수행할 횟수를 받아서 레이싱 게임을 진행한 후 결과를 반환한다`() {
        val tryNumber = TryNumber(5)
        val movingStrategy = MovingStrategy { true }
        val cars = Cars(
            listOf(
                Car(CarName("sam"), 5, movingStrategy),
                Car(CarName("kaka"), 2, movingStrategy),
                Car(CarName("luci"), 4, movingStrategy),
                Car(CarName("andy"), 5, movingStrategy)
            )
        )

        val expectedResult = RacingGameResult(
            result = List(tryNumber.number) { currentTryNumber ->
                RacingDataPerTry(
                    cars = Cars(
                        listOf(
                            Car(CarName("sam"), 5 + currentTryNumber + 1, movingStrategy),
                            Car(CarName("kaka"), 2 + currentTryNumber + 1, movingStrategy),
                            Car(CarName("luci"), 4 + currentTryNumber + 1, movingStrategy),
                            Car(CarName("andy"), 5 + currentTryNumber + 1, movingStrategy)
                        )
                    ),
                )
            },
            winners = Cars(
                listOf(
                    Car(CarName("sam"), 5 + tryNumber.number, movingStrategy),
                    Car(CarName("andy"), 5 + tryNumber.number, movingStrategy)
                )
            ),
        )

        val racingGame = RacingGame(tryNumber = tryNumber, cars = cars)
        val result = racingGame.startGame()

        assertThat(result).isEqualTo(expectedResult)
    }
}
