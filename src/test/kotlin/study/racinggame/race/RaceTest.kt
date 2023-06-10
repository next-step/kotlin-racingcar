package study.racinggame.race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racinggame.domain.Race
import study.racinggame.race.mock.MockInputReader
import study.racinggame.race.mock.MockRandom
import study.racinggame.race.view.InputView

class RaceTest : StringSpec({
    val mockInputReader = MockInputReader(listOf("3", "5"))
    val inputView = InputView().initInputView(mockInputReader)

    "모든 차가 앞으로 나가는 경우 테스트" {
        val mockRaceRule = RaceRule(MockRandom(Int.MAX_VALUE))
        val race = Race(inputView, mockRaceRule)
        race.startRace()

        for (car in race.carStorage()) {
            car.position() shouldBe 5
        }
    }

    "모든 차가 앞으로 나가지 못한 테스트" {
        val mockRaceRule = RaceRule(MockRandom(Int.MIN_VALUE))
        val race = Race(inputView, mockRaceRule)
        race.startRace()

        for (car in race.carStorage()) {
            car.position() shouldBe 0
        }
    }
})
