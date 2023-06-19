package study.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racing.car.Car
import study.racing.car.CarList
import study.racing.car.CarRanker
import study.racing.car.factory.CarListFactory
import study.racing.renderer.StdoutRenderer
import study.racing.resultview.RacingResultView

class RacingTests : StringSpec({

    "레이싱을 진행한다" {
        val carListFactory =
            CarListFactory { CarList(listOf(Car("A", 1), Car("B", 0))) }
        val resultView = RacingResultView("-", StdoutRenderer())
        val racing =
            Racing(carListFactory, CarRanker(), { 1 }, resultView)
        val winners = racing.start(1)
        winners.size shouldBe 1
        winners.first().name shouldBe "A"
        winners.first().totalMoved shouldBe 2
    }
})
