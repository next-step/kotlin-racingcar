package step3.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize

class RacingGameTest : FunSpec({

    test("경주 후 최소 한명 이상의 우승자를 반환할 수 있다.") {
        // given
        val cars = listOf(Car("one"), Car("two"), Car("three"))
        val totalCount = 5
        val racingGame = RacingGame(Cars(cars), totalCount)

        // when
        val actual = racingGame.run()

        // then
        actual.winnerNames shouldHaveAtLeastSize 1
    }
})
