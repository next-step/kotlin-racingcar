package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.model.CarRacer.Companion.CHARACTER_MOVE

internal class CarRacerTest : StringSpec({
    "생성된 카운트가 4이상이면 경로를 생성한다" {
        val racer = CarRacer()
        racer.moveTo(4)
        racer.path shouldBe CHARACTER_MOVE
    }
    "생성된 카운트가 4미만이면 경로가 없다" {
        val racer = CarRacer()
        racer.moveTo(3)
        racer.path shouldBe ""
    }
})
