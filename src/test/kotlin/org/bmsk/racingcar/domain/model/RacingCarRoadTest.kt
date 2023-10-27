package org.bmsk.racingcar.domain.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import org.bmsk.racingcar.domain.policy.MovementPolicy

class RacingCarRoadTest : FunSpec({
    context("RaccingCarRoad에서") {
        context("RandomMovement 정책을 가진 차들은") {
            val randomMovement = MovementPolicy.RandomMovement()
            test("모든 차들은 움직이면 전진하거나 전진하지 않는다.") {
                val racingCarRoad = RacingCarRoad(
                    cars = listOf(
                        Car(movementPolicy = randomMovement),
                        Car(movementPolicy = randomMovement),
                        Car(movementPolicy = randomMovement),
                        Car(movementPolicy = randomMovement),
                        Car(movementPolicy = randomMovement),
                    ),
                ).getMovedRacingCarRoad()

                racingCarRoad.cars.forEach {
                    it.position.xPos shouldBeInRange 0..1
                }
            }
        }
    }
})
