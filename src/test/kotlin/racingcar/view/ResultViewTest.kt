package racingcar.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class ResultViewTest : StringSpec({

    "우승자를 찾는다" {
        // arrange
        val finalResultOfCarRacing = mapOf(
            "pobi" to 3,
            "crong" to 4,
            "honux" to 3
        )

        // act
        val winners = ResultView.findWinners(finalResult = finalResultOfCarRacing)

        // assert
        winners shouldHaveSize 1
        winners.first() shouldBe "crong"
    }

    "우승자는 여러 명일 수 있다" {
        // arrange
        val finalResultOfCarRacing = mapOf(
            "pobi" to 3,
            "crong" to 4,
            "honux" to 4
        )

        // act
        val winners = ResultView.findWinners(finalResult = finalResultOfCarRacing)

        // assert
        winners shouldHaveSize 2
        winners.intersect(setOf("crong", "honux"))
    }
})
