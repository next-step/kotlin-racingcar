package racingcar.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.engine.Distance
import racingcar.engine.Engine

internal class CarTest : StringSpec({

    "주어진 engine 에 따라 위치가 변경된다" {
        val stubEngine = object : Engine {
            override fun accelerate(): Distance = Distance(100)
        }
        val car = Car(stubEngine)

        car.forward()

        car.position() shouldBe Position(100)
    }
})
