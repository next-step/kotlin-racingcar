package racing.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldBe

class CarRacingTest : BehaviorSpec({
    val condition: CarRacingCondition = CarRacingConditionImpl
    val recorder: CarRacingRecordStrategy = CarRacingRecorder

    given("자동차 0대로") {
        val carNames = emptyList<String>()
        `when`("자동차 경주를 하면") {
            then("예외가 발생한다") {
                shouldThrowWithMessage<IllegalArgumentException>("자동차가 0대이면 자동차 경주를 할 수 없습니다.") {
                    CarRacing.of(condition, recorder, carNames)
                }
            }
        }
    }

    given("몇 대의 자동차로 몇 번의 이동을 할 것인가 주어지고") {
        forAll(
            row(listOf("pobi", "crong"), 5),
            row(listOf("pobi", "crong", "honux"), 7),
            row(listOf("pobi", "crong", "honux"), 10)
        ) { carNames, tryCount ->
            `when`("자동차 게임을 하면") {
                val (cars, results, winners) = CarRacing.of(condition, recorder, carNames).race(tryCount)
                then("몇 대의 자동차로 몇 번의 이동한 결과를 반환한다") {
                    results shouldBeSameSizeAs List(tryCount) { cars }
                }
                then("우승자는 한 명 이상이다") {
                    winners shouldHaveAtLeastSize 1
                }
                then("우승자는 가장 많이 움직인 자동차이다") {
                    winners shouldBe CarRacingRecorder.findWinners(cars)
                }
            }
        }
    }

    given("자동차 경주 게임을 종료한 결과") {
        val carRacing = CarRacing.of(
            recorder,
            cars = listOf(
                Car.of(CarRacingMoveCondition, name = "pobi"),
                Car.of(CarRacingStopCondition, name = "crong"),
                Car.of(CarRacingMoveCondition, name = "honux"),
            )
        )
        `when`("pobi = 10, crong = 0, honux = 10 이라면") {
            val result = carRacing.race(tryCount = 10)
            then("우승자는 pobi와 crong이다.") {
                result.winners shouldBe listOf("pobi", "honux")
            }
        }
    }
})
