package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.controller.CarSnapShot
import racingcar.controller.RacingCarGameSnapShot
import racingcar.controller.RacingCarGameSnapShots

internal class ResultViewTest {
    @Test
    fun `Parse game snapShots to text`() {

        val snapShots = RacingCarGameSnapShots(
            RacingCarGameSnapShot(listOf(CarSnapShot(position = 1), CarSnapShot(position = 0))),
            RacingCarGameSnapShot(listOf(CarSnapShot(position = 2), CarSnapShot(position = 0))),
        )
        ResultView.toSnapShotsText(snapShots) shouldBe """
            |-
            |
            |
            |--
            |"""
            .trimMargin()
    }
}
