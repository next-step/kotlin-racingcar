package racingCar.controller

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.constants.Message

/**
 * RacingController를 테스트하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingControllerTest {
    @Test
    fun `음수가 입력되었을 때 에러발생`() {
        val racingController = RacingController()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            racingController.startGame(-1, -3)
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `0이 입력되었을 때 에러발생`() {
        val racingController = RacingController()
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            racingController.startGame(0, 0)
        }.withMessageMatching(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
    }

    @Test
    fun `입력된 숫자만큼 레이스 결과가가 만들어졌는가`() {
        val racingController = RacingController()
        racingController.startGame(3, 3)
        assertThat(racingController.raceResults.size).isEqualTo(3)
    }

    @Test
    fun `입력된 숫자만큼 레이싱카가 만들어졌는가`() {
        val racingController = RacingController()
        racingController.startGame(3, 3)
        val carList = racingController::class.java.getDeclaredField("carLists").apply {
            isAccessible = true
        }.get(racingController) as MutableList<*>
        assertThat(carList.size).isEqualTo(3)
    }

    @Test
    fun `숫자가 4이상일때만 전진하는가`() {
        val racingController = RacingController()
        val method = racingController::class.java.getDeclaredMethod("checkCanRunScore", Int::class.java).apply {
            isAccessible = true
        }
        assertThat(method.invoke(racingController, 3)).isEqualTo(false)
        assertThat(method.invoke(racingController, 4)).isEqualTo(true)
    }

    @Test
    fun `랜덤한 숫자는 0에서 9 사이인가`() {
        val racingController = RacingController()
        val method = racingController::class.java.getDeclaredMethod("rollTheDice").apply {
            isAccessible = true
        }

        val minimumScore = racingController::class.java.getDeclaredField("MINIMUM_SCORE").apply {
            isAccessible = true
        }.get(racingController) as Int
        val exceededScore = racingController::class.java.getDeclaredField("EXCEEDED_SCORE").apply {
            isAccessible = true
        }.get(racingController) as Int
        val successList = minimumScore until exceededScore
        repeat(TEST_NUMBER_OF_ROLL_DICE) {
            assertThat(successList).contains(method.invoke(racingController) as Int)
        }
    }

    companion object {
        private const val TEST_NUMBER_OF_ROLL_DICE = 100
    }
}
