package racingcar.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.engine.Engine
import racingcar.engine.Speed

internal class RacingCarTest : StringSpec({

    "자동차의 초기 위치는 0이다" {
        val stubEngine = Engine { Speed(10) }

        val racingCar = RacingCar(stubEngine)

        racingCar.position() shouldBe Position(0)
    }

    "속도가 0인 엔진을 제공하는 경우 위치는 0으로 유지된다." {
        val stubEngine = Engine { Speed(0) }
        val racingCar = RacingCar(stubEngine)

        val result = racingCar.forward()

        result.position() shouldBe Position(0)
    }

    "매번 전진하는 엔진을 제공하는 경우 위치는 엔진의 속도만큼 증가한다." {
        val stubEngine = Engine { Speed(10) }
        val racingCar = RacingCar(stubEngine)

        val result = racingCar.forward()

        result.position() shouldBe Position(10)
    }

    "총 이동한 거리를 반환한다" {
        val stubEngine = object : Engine {
            private var shouldForward = false
            override fun accelerate(): Speed {
                if (shouldForward) {
                    shouldForward = false
                    return Speed(1)
                }
                shouldForward = true
                return Speed(0)
            }
        }
        var racingCar: Car = RacingCar(stubEngine)

        repeat(10) { racingCar = racingCar.forward() }

        racingCar.position() shouldBe Position(5)
    }
})
