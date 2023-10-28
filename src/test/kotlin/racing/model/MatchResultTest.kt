package racing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MatchResultTest : StringSpec({
    "경기 결과가 의도대로 잘 표현되어야한다" {
        val actual1 = MatchResult(
            ArrayDeque(
                listOf(Car(1, 3), Car(2, 2), Car(3, 1)),
            )
        ).consolePresent()
        actual1 shouldBe "---\n--\n-"

        val actual2 = MatchResult(
            ArrayDeque(
                listOf(Car(1, 2), Car(2, 2), Car(3, 2)),
            )
        ).consolePresent()
        actual2 shouldBe "--\n--\n--"
    }
})
