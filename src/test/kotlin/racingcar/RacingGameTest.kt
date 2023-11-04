package racingcar

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(ints = [-12, 0, -1])
    fun `실패 - 0 이하의 게임횟수, 자동차 수 입력`(input: Int) {

        assertThatThrownBy { InputView().validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("음수는 입력할 수 없습니다.")
    }
}
