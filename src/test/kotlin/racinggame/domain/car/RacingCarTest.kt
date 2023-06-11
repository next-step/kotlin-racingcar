package racinggame.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.engine.MockEngine
import racinggame.domain.car.factory.RacingCarUniqueKey
import racinggame.domain.player.Racer

class RacingCarTest : BehaviorSpec({

    fun mockRacingCar(
        drivableDistance: DrivableDistance,
    ): RacingCar {
        return RacingCar(
            uniqueKey = RacingCarUniqueKey(value = "test"),
            racer = Racer(id = "test", ordinal = 0),
            engine = MockEngine(drivableDistance)
        )
    }

    Given("무조건 이동하는 엔진을 갖은 자동차가 존재할 때") {
        val fixedDrivableDistance = DrivableDistance(1)
        val racingCar = mockRacingCar(fixedDrivableDistance)
        When("자동차 이동을 시도하면") {
            Then("이동 가능한 주행 거리를 반환한다") {
                racingCar.tryRun() shouldBe fixedDrivableDistance
            }
        }
    }

    Given("무조건 이동하지 않는 엔진을 갖은 자동차가 존재할 때") {
        val fixedDrivableDistance = DrivableDistance(0)
        val racingCar = mockRacingCar(fixedDrivableDistance)
        When("자동차 이동을 시도하면") {
            Then("주행 가능 거리를 0으로 반환한다") {
                racingCar.tryRun() shouldBe fixedDrivableDistance
            }
        }
    }
})
