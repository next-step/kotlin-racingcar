package week1.step4.racinggame.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe

val alwaysMovingNumberGenerator = RandomNumberGenerator { 4 }

class RacingGameTest : StringSpec({
    "RacingGame의 round를 실행하면 각 자동차들은 해당 라운드를 진행한다" {
        val carNames = listOf("pobi", "crong", "honux").map { CarName(it) }
        val carRoster = CarRoster(carNames)

        val sut = RacingGame(carRoster, alwaysMovingNumberGenerator)

        sut.round()

        sut.cars.forEach { it.position shouldBe 1 }
    }

    "RacingGame 에서 레이스 실행 후 우승자들을 받을 수 있다(3팀 무조건 전진)" {
        val carNames = listOf("pobi", "crong", "honux").map { CarName(it) }
        val carRoster = CarRoster(carNames)

        val sut = RacingGame(carRoster, alwaysMovingNumberGenerator)

        val round = 5
        (1..round).forEach {
            sut.round()
        }

        val results = sut.getWinners()

        results.size shouldBe 3
        results.forEach { car ->
            car.carName shouldBeIn carNames
            car.position shouldBe round
        }
    }

    "RacingGame 에서 레이스 실행 후 우승자들을 받을 수 있다(1팀 무조건 전진, 2팀 무조건 멈춤)" {
        val carNames = listOf("pobi", "crong", "honux").map { CarName(it) }
        val carRoster = CarRoster(carNames)

        val candidates = listOf(4, 3, 3)
        var index = 0
        val onlyFirstCarAlwaysMoveGenerator =
            RandomNumberGenerator {
                candidates[index++ % candidates.size]
            }

        val sut = RacingGame(carRoster, onlyFirstCarAlwaysMoveGenerator)

        val round = 5
        (1..round).forEach {
            sut.round()
        }

        val results = sut.getWinners()

        results.size shouldBe 1
        results[0].carName.value shouldBe "pobi"
        results[0].position shouldBe round
    }
})
