package study.step3.race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.step3.race.mock.MockInputReader
import study.step3.race.mock.MockRandom

class RaceTest : StringSpec({
    val mockInputReader = MockInputReader(listOf("3", "5"))
    val command = Command(mockInputReader)

    "startRace 호출 시 moveCarsIfPossible 동작 테스트" {
        val mockRandom = MockRandom(Int.MAX_VALUE)
        val race = Race(command, mockRandom)
        race.startRace()

        for (car in command.carStorage()) {
            car shouldBe 5 // 모든 차량이 5번 전진했어야 함
        }
    }

    "아무도 앞으로 나가지 못하는 경우" {
        val mockRandom = MockRandom(Int.MIN_VALUE)
        val race = Race(command, mockRandom)
        race.startRace()

        for (car in command.carStorage()) {
            car shouldBe 0
        }
    }
})
