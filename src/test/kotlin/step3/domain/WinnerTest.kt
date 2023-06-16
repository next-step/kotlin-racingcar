package step3.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinnerTest : FunSpec({
    test("우승자를 가려낼 수 있다.") {
        // given
        val cars = Cars(
            listOf(Car("red", 1), Car("blue", 2), Car("green", 3))
        )
        val expected = listOf("green")

        // when
        val actual = Winner(cars)

        // then
        actual.winnerNames.shouldBe(expected)
    }
})
