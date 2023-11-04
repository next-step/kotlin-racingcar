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

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `무작위 수 4 이상이면 자동차 전진`(num : Int) {

        val car = Car(moveCondition = RandomNumberHolderImpl()).apply {
            moveCondition = object : RandomNumberHolder {
                override fun getRandomNumber(): Int {
                    return num
                }
            }
        }

        car.move()
        car.position shouldBe 1
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `무작위 수 4 이하면 정지`(num : Int) {

        val car = Car(moveCondition = RandomNumberHolderImpl()).apply {
            moveCondition = object : RandomNumberHolder {
                override fun getRandomNumber(): Int {
                    return num
                }
            }
        }

        car.move()
        car.position shouldBe 0
    }
}
