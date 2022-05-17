package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingResultTest : StringSpec({
    "우승자를 찾는 기능" {
        // given
        val racingResult = RacingResult(
            listOf(
                Cars(
                    listOf(
                        Car(Name("a"), 1),
                        Car(Name("b"), 2),
                    ),
                ),
            )
        )

        // when
        val actual = racingResult.getWinners()

        // then
        actual.size shouldBe 1
        actual[0].value shouldBe "b"
    }
})
