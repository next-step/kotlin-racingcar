package racing.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.Car
import racing.model.MatchResult

class ConsoleRenderTest : StringSpec({

    "경기 결과가 의도대로 잘 표현되어야한다" {
        val matchResult = MatchResult(
            ArrayDeque(
                listOf(Car(1, 3), Car(2, 2), Car(3, 1), Car(4, 5))
            )
        )
        val actual = ConsoleRender().consolePresent(matchResult)
        actual shouldBe "---\n--\n-\n-----"
    }
})
