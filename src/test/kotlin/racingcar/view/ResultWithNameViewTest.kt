package racingcar.view

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.controller.CarSnapShot
import racingcar.controller.RacingCarGameSnapShot
import racingcar.controller.RacingCarGameSnapShots

internal class ResultWithNameViewTest {
    @Test
    fun `Parse game snapShots to text ( name, position )`() {

        val snapShots = RacingCarGameSnapShots(
            listOf(
                RacingCarGameSnapShot(
                    listOf(CarSnapShot("mia", 1), CarSnapShot("comp", 2))
                ),
                RacingCarGameSnapShot(
                    listOf(CarSnapShot("mia", 3), CarSnapShot("comp", 2))
                )
            )
        )
        ResultWithNameView.toSnapShotsText(snapShots) shouldBe """
        |mia : -
        |comp : --
        |
        |mia : ---
        |comp : --
        |
        |mia가 최종 우승했습니다.
        |""".trimMargin()
    }
    @Test
    fun `print winner`() {

        val snapShots = RacingCarGameSnapShots(
            listOf(
                RacingCarGameSnapShot(
                    listOf(CarSnapShot("mia", 1), CarSnapShot("comp", 1))
                )
            )
        )
        ResultWithNameView.toSnapShotsText(snapShots) shouldBe """
        |mia : -
        |comp : -
        |
        |mia, comp가 최종 우승했습니다.
        |""".trimMargin()
    }
}
