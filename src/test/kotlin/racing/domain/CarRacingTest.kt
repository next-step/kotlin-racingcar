package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldBe

class CarRacingTest : BehaviorSpec({
    val repository: CarRepository = CarRepositoryImpl
    val numberStrategy: NumberStrategy = RandomNumberStrategy
    val recorder: CarRacingRecordStrategy = CarRacingRecorder

    given("몇 대의 자동차로 몇 번의 이동을 할 것인가 주어지고") {
        forAll(
            row(listOf("pobi", "crong"), 5),
            row(listOf("pobi", "crong", "honux"), 7),
            row(listOf("pobi", "crong", "honux"), 10)
        ) { carNames, tryCount ->
            val cars: List<Car> = repository.createCars(carNames)
            `when`("자동차 게임을 하면") {
                val (results, winners) = CarRacing(numberStrategy, recorder, cars).race(tryCount)
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
})
