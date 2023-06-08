package study.step3.race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.step3.race.mock.MockInputReader
import study.step3.race.mock.MockRandom

class RaceTest : StringSpec({
    val mockInputReader = MockInputReader(listOf("3", "5"))
    val inputView = InputView(mockInputReader)

    "모든 차가 앞으로 나가는 경우 테스트" {
        val mockRandom = MockRandom(Int.MAX_VALUE)
        val race = Race(inputView, mockRandom)
        race.startRace()

        for (car in race.carStorage) {
            car.position shouldBe 5
        }
    }

    "모든 차가 앞으로 나가지 못한 테스트" {
        val mockRandom = MockRandom(Int.MIN_VALUE)
        val race = Race(inputView, mockRandom)
        race.startRace()

        for (car in race.carStorage) {
            car.position shouldBe 0
        }
    }
})
