package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.controller.RacingCarGameSnapShot
import racingcar.controller.RacingCarGameSnapShots

internal class ResultViewTest {
    @Test
    fun `Parse game snapShots to text`() {

        val snapShots = RacingCarGameSnapShots(
            RacingCarGameSnapShot(listOf(1, 0)),
            RacingCarGameSnapShot(listOf(2, 0))
        )
        ResultView(snapShots).snapStopText shouldBe """
            |-
            |
            |
            |--
            |"""
            .trimMargin()
    }
}
