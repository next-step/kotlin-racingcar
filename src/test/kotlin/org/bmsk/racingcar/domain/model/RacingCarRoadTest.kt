package org.bmsk.racingcar.domain.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.bmsk.racingcar.domain.error.RacingCarErrorMessage
import org.bmsk.racingcar.domain.policy.movement.RandomMovementImpl

class RacingCarRoadTest : FunSpec({
    test("RacingCarRoad를 빈 리스트로 초기화 할 수 없다.") {
        shouldThrow<IllegalArgumentException> {
            RacingCarRoad(emptyList())
        }.shouldHaveMessage(RacingCarErrorMessage.LIST_OF_CARS_CANNOT_BE_EMPTY.message)
    }

    context("RacingCarRoad의 차들이") {
        context("RandomMovement 정책을 따를 때") {
            val randomMovement = RandomMovementImpl()
            val fakeRandomMovement1 = RandomMovementImpl(FakeRandomGenerator(1))
            val fakeRandomMovement3 = RandomMovementImpl(FakeRandomGenerator(3))
            val fakeRandomMovement4 = RandomMovementImpl(FakeRandomGenerator(4))
            val fakeRandomMovement9 = RandomMovementImpl(FakeRandomGenerator(9))

            test("첫 움직임 후 모든 차들의 위치가 0 또는 1이어야 한다.") {
                // 준비
                val initialRacingCarRoad = RacingCarRoad(
                    cars = List(5) { Car(movementPolicy = randomMovement) },
                )

                // 실행
                val movedRacingCarRoad = initialRacingCarRoad.getMovedRacingCarRoad()

                // 검증
                movedRacingCarRoad.cars.forEach {
                    it.position.xPos shouldBeInRange 0..1
                }
            }
            test("차들의 랜덤 값이 1인 경우 해당 차들은 전진하지 않는다.") {
                // 준비
                val initialRacingCarRoad = RacingCarRoad(
                    cars = List(5) { Car(movementPolicy = fakeRandomMovement1) },
                )

                // 실행
                val movedRacingCarRoad = initialRacingCarRoad.getMovedRacingCarRoad()

                // 검증
                movedRacingCarRoad.cars.forEach {
                    it.position.xPos shouldBe 0
                }
            }

            test("차들의 랜덤 값이 4인 경우 해당 차들은 전진한다.") {
                // 준비
                val initialRacingCarRoad = RacingCarRoad(
                    cars = List(5) { Car(movementPolicy = fakeRandomMovement4) },
                )

                // 실행
                val movedRacingCarRoad = initialRacingCarRoad.getMovedRacingCarRoad()

                // 검증
                movedRacingCarRoad.cars.forEach {
                    it.position.xPos shouldBe 1
                }
            }

            test("차들의 랜덤 값이 섞여 있는 경우 4이상의 값을 가진 차들만이 전진한다.") {
                // 준비
                val initialRacingCarRoad = RacingCarRoad(
                    cars = List(5) { Car(movementPolicy = fakeRandomMovement3) } + List(5) { Car(movementPolicy = fakeRandomMovement9) },
                )

                // 실행
                val movedRacingCarRoad = initialRacingCarRoad.getMovedRacingCarRoad()

                // 검증
                movedRacingCarRoad.cars.subList(0, 5).forEach {
                    it.position.xPos shouldBe 0
                }
                movedRacingCarRoad.cars.subList(5, 10).forEach {
                    it.position.xPos shouldBe 1
                }
            }
        }
    }
})
