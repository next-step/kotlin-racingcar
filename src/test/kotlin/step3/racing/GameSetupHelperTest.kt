package step3.racing

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step3.racing.const.CAR_NUMBER_ERROR
import step3.racing.const.TURN_NUMBER_ERROR
import step3.racing.mock.MockTurn

class GameSetupHelperTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 100])
    fun `askHowManyCars() 정상 입력 시 자동차 리스트 반환`(number: Int) {
        assertThat(
            GameSetupHelper()
                .askHowManyCars("$number")
                .size
        )
            .isEqualTo(number)
    }

    @Test
    fun `askHowManyCars() 잘못된 입력 시 Exception 반환`() {
        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyCars("a")
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(CAR_NUMBER_ERROR)

        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyCars(null)
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(CAR_NUMBER_ERROR)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 100])
    fun `askHowManyTurns() 정상 입력 시 TurnManager 반환`(number: Int) {
        val manager = GameSetupHelper()
            .askHowManyTurns("$number", MockTurn())
        assertThat(manager.totalSteps).isEqualTo(number)
    }

    @Test
    fun `askHowManyTurns() 잘못된 입력 시 Exception 반환`() {
        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyTurns("a", MockTurn())
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(TURN_NUMBER_ERROR)

        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyTurns(null, MockTurn())
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(TURN_NUMBER_ERROR)
    }
}
