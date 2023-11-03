package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarRepositoryTest : BehaviorSpec({
    val repository: CarRepository = CarRepositoryImpl

    given("자동차의 이름은") {
        val carNames = "pobi,crong,honux"
        then("쉼표로 구분한다") {
            val cars = repository.createCars(carNames.split(","))
            cars.map { it.name } shouldBe carNames.split(",")
        }
    }
})
