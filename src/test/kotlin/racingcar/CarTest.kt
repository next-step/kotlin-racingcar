package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("자동차에 4 이상의 힘을 가하면 전진한다") {
        withData(listOf(4, 5, 6, 7, 8, 9)) { power ->
            val car = Car(engine = { power })
            car.move()
            car.location shouldBe 1
        }
    }
    context("자동차에 4 미만의 힘을 가하면 움직이지 않는다") {
        withData(listOf(0, 1, 2, 3)) { power ->
            val car = Car(engine = { power })
            car.move()
            car.location shouldBe 0
        }
    }
})
