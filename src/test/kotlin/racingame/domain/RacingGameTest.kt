package racingame.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSize
import racingame.fixture.CarFixture.CAR_BLUE
import racingame.fixture.CarFixture.CAR_GREEN
import racingame.fixture.CarFixture.CAR_RED

class RacingGameTest : FunSpec({

    test("경주 후 최소 한명 이상의 우승자를 반환할 수 있다.") {
        // given
        val cars = listOf(CAR_RED, CAR_GREEN, CAR_BLUE)
        val totalCount = 5
        val racingGame = RacingGame(Cars(cars), totalCount)

        // when
        val actual = racingGame.run()

        // then
        actual.nameOfWinners shouldHaveAtLeastSize 1
    }

    test("경주 횟수만큼 racing history 를 저장할 수 있다.") {
        // given
        val cars = listOf(CAR_RED, CAR_GREEN, CAR_BLUE)
        val totalCount = 5
        val racingGame = RacingGame(Cars(cars), totalCount)

        // when
        racingGame.run()

        // then
        racingGame.racingHistories shouldHaveSize totalCount
    }
})
