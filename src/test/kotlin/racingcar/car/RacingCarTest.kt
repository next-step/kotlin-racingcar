package racingcar.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.engine.Distance
import racingcar.engine.Engine

internal class RacingCarTest : StringSpec({

    "주어진 engine 에 따라 위치가 변경된다" {
        val stubEngine = Engine { Distance(100) }
        val racingCar = RacingCar(stubEngine)

        val result = racingCar.forward()

        result.position() shouldBe Position(100)
    }

    "총 이동한 거리를 반환한다" {
        val stubEngine = object : Engine {
            private var shouldForward = false
            override fun accelerate(): Distance {
                if (shouldForward) {
                    shouldForward = false
                    return Distance(1)
                }
                shouldForward = true
                return Distance(0)
            }
        }
        var racingCar: Car = RacingCar(stubEngine)

        repeat(10) { racingCar = racingCar.forward() }

        racingCar.position() shouldBe Position(5)
    }
})
