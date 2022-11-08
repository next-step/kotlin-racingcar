package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class ResultViewTest {
    @Test
    fun `Parse game snapShots to text`() {
        val car1 = Car(1)
        car1.move(1)
        car1.move(2)

        val car2 = Car(2)
        car2.move(2)
        car2.move(0)

        val snapShots = RacingCarGameSnapShots(listOf(car1, car2))
        ResultView(snapShots).snapStopText shouldBe """-
--

---
--"""
    }
}