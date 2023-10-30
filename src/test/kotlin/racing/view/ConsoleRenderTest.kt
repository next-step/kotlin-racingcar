package racing.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import racing.model.Car
import racing.model.RacingHistory

class ConsoleRenderTest : StringSpec({

    "경기 결과가 이동거리1당 \'-\' 문자로 표현되어야 한다" {
        val racingHistory = RacingHistory(
            ArrayDeque(
                listOf(
                    Car("1", 3),
                    Car("2", 2),
                    Car("3", 1),
                    Car("4", 5)
                ),
            )
        )
        val actual = ConsoleRender.consolePresent(racingHistory)
        actual shouldBe "1 : ---\n2 : --\n3 : -\n4 : -----"
    }

    "전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다" {
        val racingHistory = RacingHistory(
            ArrayDeque(
                listOf(
                    Car("코틀린", 0),
                    Car("자바", 0),
                    Car("고랭", 0),
                    Car("TS", 0),
                ),
            )
        )

        val actual = ConsoleRender.consolePresent(racingHistory)
        actual shouldContain "코틀린"
        actual shouldContain "자바"
        actual shouldContain "고랭"
        actual shouldContain "TS"
    }
})
