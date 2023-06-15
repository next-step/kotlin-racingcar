package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class CarListTest : BehaviorSpec({

    Given("CarList") {
        When("정상적인 carNames 입력될 때") {
            val inputData = listOf(
                "one,two,three" to 3,
                "소나타,벤츠,네시스,케딜락,에쿠스" to 5
            )

            Then("입력된 개수만큼 Car 생성됨") {
                inputData.forAll { data ->
                    CarList.of(data.first).cars.size shouldBe data.second
                }
            }
        }

        When("race(5) 실행 시") {
            val tryCount = 5
            val carList = CarList.of("1, 2, 3, 4, 5")
            Then("모든 Car가 race() 실행") {
                carList.race(tryCount)
                carList.cars.forAll { car -> car.carRecord.record.size shouldBe tryCount }
            }
        }
    }
})
