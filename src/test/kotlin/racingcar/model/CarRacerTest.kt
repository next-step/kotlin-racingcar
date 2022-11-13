package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import racingcar.model.CarRacer.Companion.CHARACTER_MOVE

internal class CarRacerTest : StringSpec({
    "랜덤하게 9 보다 작거나 같은 카운트를 생성한다" {
        val racer = CarRacer()
        val count = racer.generateCount()
        count shouldBeLessThanOrEqual 9
    }
    "랜덤하게 0 보다 크거나 같은 카운트를 생성한다" {
        val racer = CarRacer()
        val count = racer.generateCount()
        count shouldBeGreaterThanOrEqual 0
    }
    "생성된 카운트가 4이상이면 경로를 생성한다" {
        val racer = CarRacer()
        racer.move(4)
        racer.path shouldBe CHARACTER_MOVE
    }
    "생성된 카운트가 4미만이면 경로가 없다" {
        val racer = CarRacer()
        racer.move(3)
        racer.path shouldBe ""
    }
})
