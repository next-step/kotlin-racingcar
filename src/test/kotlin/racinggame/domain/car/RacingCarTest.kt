package racinggame.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.car.engine.Engine
import racinggame.domain.car.engine.MockNotMoveEngine
import racinggame.domain.car.engine.MockOneSpaceMovementEngine
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

class RacingCarTest : BehaviorSpec({

    fun mockRacingCar(
        engine: Engine,
    ): RacingCar {
        return RacingCar(
            user = User(id = UserUniqueId.create(), ordinal = 0),
            engine = engine,
        )
    }

    Given("무조건 이동하는 엔진을 갖은 자동차가 존재할 때") {
        val racingCar = mockRacingCar(engine = MockOneSpaceMovementEngine())
        When("자동차 이동을 시도하면") {
            Then("이동 가능한 주행 거리를 반환한다") {
                racingCar.tryRun().value shouldBe 1
            }
        }
    }

    Given("무조건 이동하지 않는 엔진을 갖은 자동차가 존재할 때") {
        val racingCar = mockRacingCar(engine = MockNotMoveEngine())
        When("자동차 이동을 시도하면") {
            Then("주행 가능 거리를 0으로 반환한다") {
                racingCar.tryRun().value shouldBe 0
            }
        }
    }
})
