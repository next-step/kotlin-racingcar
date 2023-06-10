package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarKoTest : StringSpec({
    val moveCondition = object : MoveCondition {
        override fun isMovable(): Boolean {
            return true
        }
    }

    "한번 이동하면 position이 1 올라간다." {
        val car = Car()
        car.go(moveCondition)
        car.position shouldBe 1
    }
})
