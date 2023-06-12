package racinggame.domain.field

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.engine.MockEngine
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

class RacingFieldTest : BehaviorSpec({

    fun mockRacingCar(
        id: String,
        fixedDrivableDistance: Int = 0
    ): RacingCar {
        return RacingCar(
            user = User(id = UserUniqueId.create(), ordinal = 0),
            engine = MockEngine(fixedDrivableDistance = DrivableDistance(fixedDrivableDistance))
        )
    }

    Given("자동차들을 레이싱 필드에 대기 시켰을 때") {
        val racingCars = listOf(
            mockRacingCar(id = "car1", fixedDrivableDistance = 1),
            mockRacingCar(id = "car2", fixedDrivableDistance = 2),
        )
        val racingField = RacingField().apply {
            ready(racingCars)
        }
        Then("자동차들의 시작 위치와 현재 위치가 0 이어야 한다") {
            racingCars.forEach { racingCar ->
                val actual = racingField.racingFieldMap
                    .getValue(racingCar.user.id)
                    .moveDistance
                val expected = MoveDistance(0)
                actual shouldBe expected
            }
        }
        When("출발 신호를 보내면") {
            racingField.publishGoSignal()
            Then("자동차들의 이동 가능 거리만큼 필드에서 이동한다") {
                racingCars.forEach { racingCar ->
                    val actual = racingField.racingFieldMap
                        .getValue(racingCar.user.id)
                        .moveDistance
                    val expected = MoveDistance(racingCar.tryRun().value)
                    actual shouldBe expected
                }
            }
        }
        When("필드를 초기화하면") {
            racingField.clear()
            Then("필드에 자동차들이 존재하지 않는다") {
                racingField.racingFieldMap.size shouldBe 0
            }
        }
    }
})
