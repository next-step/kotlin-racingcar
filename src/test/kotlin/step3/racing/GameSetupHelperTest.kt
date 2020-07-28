package step3.racing

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step3.racing.const.CAR_NUMBER_ERROR
import step3.racing.const.ERROR_CAR_NAME_OVERFLOW
import step3.racing.const.TURN_NUMBER_ERROR

class GameSetupHelperTest {

    @Test
    fun `askHowManyCars() 정상 입력 시 자동차 리스트 반환`() {
        assertThat(
            GameSetupHelper()
                .askHowManyCars("1, 2, 3")
                .size
        )
            .isEqualTo(3)

        assertThat(
            GameSetupHelper()
                .askHowManyCars("1, 2, 3, 44, 55, 66, 77, 88, 99, 100")
                .size
        )
            .isEqualTo(10)
    }

    @Test
    fun `askHowManyCars() 잘못된 입력 시 Exception 반환`() {
        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyCars("123123123")
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(ERROR_CAR_NAME_OVERFLOW)

        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyCars(null)
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(CAR_NUMBER_ERROR)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 100])
    fun `askHowManyTurns() 정상 입력 시 턴의 수 반환`(number: Int) {
        val turns = GameSetupHelper()
            .askHowManyTurns("$number")
        assertThat(turns).isEqualTo(number)
    }

    @Test
    fun `askHowManyTurns() 잘못된 입력 시 Exception 반환`() {
        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyTurns("a")
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(TURN_NUMBER_ERROR)

        Assertions.assertThatThrownBy {
            GameSetupHelper().askHowManyTurns(null)
        }
            .isInstanceOf(RacingCarGame.SetupFailException::class.java)
            .hasMessage(TURN_NUMBER_ERROR)
    }
}
