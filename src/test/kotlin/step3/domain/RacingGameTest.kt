package step3.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : FunSpec({

    test("경주에 참여한 car 리스트를 반환할 수 있다.") {
        // given
        val cars = listOf(Car("one"), Car("two"), Car("three"))
        val totalCount = 5
        val racingGame = RacingGame(cars, totalCount)

        // when
        val actual = racingGame.getCars()

        // then
        actual shouldBe cars
    }
})
