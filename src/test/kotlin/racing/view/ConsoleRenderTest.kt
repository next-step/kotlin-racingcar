package racing.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.Car
import racing.model.RacingHistory

class ConsoleRenderTest : StringSpec({

    "경기 결과가 이동거리1당 \'-\' 문자로 표현되어야 한다" {
        val racingHistory = RacingHistory(
            ArrayDeque(
                listOf(
                    Car(1, 3),
                    Car(2, 2),
                    Car(3, 1),
                    Car(4, 5)
                ),
            )
        )
        val actual = ConsoleRender().consolePresent(racingHistory)
        actual shouldBe "---\n--\n-\n-----"
    }

    "전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다" {
        TODO()
    }
})
