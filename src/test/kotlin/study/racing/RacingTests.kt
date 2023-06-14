package study.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racing.car.Car
import study.racing.car.CarRanker
import study.racing.car.factory.CarFactory
import study.racing.movement.condition.MovementConditionGenerator
import study.racing.renderer.StdoutRenderer
import study.racing.resultview.CarNameDisplayedResultView
import study.racing.resultview.RankedResultView

class RacingTests : StringSpec({

    "레이싱을 진행한다" {
        val carFactory =
            CarFactory { listOf(Car("A", 1), Car("B", 0)) }
        val progressResultView = CarNameDisplayedResultView("-", StdoutRenderer())
        val rankedResultView = RankedResultView(StdoutRenderer())
        val conditionGenerator = MovementConditionGenerator { 4 }
        val racing =
            Racing(carFactory, conditionGenerator, CarRanker(), progressResultView, rankedResultView)
        val winners = racing.start(1)
        winners.size shouldBe 1
        winners.first().name shouldBe "A"
        winners.first().totalMoved shouldBe 2
    }
})
