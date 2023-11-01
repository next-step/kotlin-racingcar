package org.bmsk.racingcar.domain.policy.ranking

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.bmsk.racingcar.domain.model.Car
import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner
import org.bmsk.racingcar.domain.policy.movement.RandomMovementImpl
import org.bmsk.racingcar.model.Position

class RankingPolicyTest : BehaviorSpec({
    given("가장 멀리 간 자동차가 한 대이다.") {
        val cars = List(10) {
            Car(movementPolicy = RandomMovementImpl(), position = Position(xPos = 0))
        } + Car(movementPolicy = RandomMovementImpl(), position = Position(xPos = 1))

        val racingCarRoad = RacingCarRoad(cars = cars)
        `when`("다수의 우승자를 허락하는 정책이다.") {
            val rankingPolicy = MultipleWinnersAllowedImpl()
            then("우승자는 하나이다.") {
                rankingPolicy.determineWinner(racingCarRoad).cars.size shouldBe 1
            }
        }
    }

    val scenarios = table(
        headers("numberOfWinners"),
        row(1),
        row(2),
        row(3),
        row(4),
        row(5),
    )
    forAll(scenarios) { numberOfWinners ->
        given("가장 멀리 간 자동차가 $numberOfWinners 대이다.") {
            val cars = List(10 - numberOfWinners) {
                Car(movementPolicy = RandomMovementImpl(), position = Position(xPos = 0))
            } + List(numberOfWinners) {
                Car(movementPolicy = RandomMovementImpl(), position = Position(xPos = 1))
            }

            val racingCarRoad = RacingCarRoad(cars = cars)
            `when`("다수의 우승자를 허락하는 정책이다.") {
                val rankingPolicy = MultipleWinnersAllowedImpl()
                then("우승자는 ${numberOfWinners}명이다.") {
                    rankingPolicy.determineWinner(racingCarRoad).cars.size shouldBe numberOfWinners
                }
            }
            `when`("하나의 우승자만 허락하는 정책이다.") {
                val rankingPolicy = SingleWinnerOnlyImpl()
                then("우승자는 1명이다.") {
                    rankingPolicy.determineWinner(racingCarRoad).shouldBeInstanceOf<RacingCarWinner.SingleWinner>()
                }
            }
        }
    }
})
