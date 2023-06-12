package study.racinggame.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racinggame.domain.Car
import study.racinggame.domain.Race
import study.racinggame.domain.RaceRule
import study.racinggame.service.mock.MockRandom

class RaceTest : StringSpec({
    "모든 차가 앞으로 나가는 경우 테스트" {
        val testCars = listOf(Car(name = "test1"), Car(name = "test2"))
        val mockRaceRule = RaceRule(MockRandom(Int.MAX_VALUE))
        val race = Race(testCars, mockRaceRule)
        race.runTrack()

        for (car in race.carStorage()) {
            car.position shouldBe 2
        }
    }

    "모든 차가 앞으로 나가지 못한 테스트" {
        val testCars = listOf(Car(name = "test1"), Car(name = "test2"))
        val mockRaceRule = RaceRule(MockRandom(Int.MIN_VALUE))
        val race = Race(testCars, mockRaceRule)
        race.runTrack()

        for (car in race.carStorage()) {
            car.position shouldBe 1
        }
    }

    "우승자의 이름을 가져올 수 있다." {
        val testCars = listOf(Car(777, "test1"), Car(0, "test2"))
        val race = Race(testCars, RaceRule())
        race.getRaceWinner() shouldBe "test1"
    }

    "우승자가 여러명이면 전부 가져온다." {
        val testCars = listOf(Car(777, "test1"), Car(777, "test2"), Car(777, "test3"))
        val race = Race(testCars, RaceRule())
        race.getRaceWinner() shouldBe "test1, test2, test3"
    }
})
