package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `성공 - 게임횟수 자동차 수를 입력`() {

        val inputView = InputView(
            gameCount = 5,
            cars = listOf(
                Car(moveCondition = RandomNumberHolderImpl()),
                Car(moveCondition = RandomNumberHolderImpl()),
                Car(moveCondition = RandomNumberHolderImpl())

            )
        )

        val racingGame = RacingGame(
            inputView.gameCount,
            inputView.cars
        )

        racingGame.gameCount shouldBe 5
        racingGame.cars.size shouldBe 3
    }
}
