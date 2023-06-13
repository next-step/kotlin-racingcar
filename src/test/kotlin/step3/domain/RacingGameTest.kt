package step3.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : FunSpec({

    test("우승자(들) 이름을 반환할 수 있다.") {
        // given
        val cars = listOf(Car("one", 5), Car("two", 5), Car("three", 3))
        val totalCount = 5
        val racingGame = RacingGame(cars, totalCount)

        // when
        val actual = racingGame.getWinners()

        // then
        actual shouldBe listOf("one", "two")
    }

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
