package camp.nextstep.edu.step.racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("자동차들 이란 일급 컬렉션은")
class CarsTest : BehaviorSpec({

    Given("자동차 이름들이 주어지고") {
        val requestCarList = listOf(
            Car(carName = "현대자동차"),
            Car(carName = "기아자동차")
        )

        When("생성을 요청하면") {
            val cars = Cars.of(cars = requestCarList)

            Then("주어진 자동차들이 생성된다") {
                cars shouldBe Cars.of(
                    cars = listOf(
                        Car(carName = "현대자동차"),
                        Car(carName = "기아자동차")
                    )
                )
            }
        }
    }

    Given("자동차들의 객체가 생성되어 있고") {
        val requestCarList = listOf(
            Car(carName = "현대자동차"),
            Car(carName = "기아자동차")
        )

        val cars = Cars.of(cars = requestCarList)

        When("참여하는 자동차들의 총 대수를 요청하면") {
            val totalCarsCount = cars.getCarsSize()

            Then("참여하는 자동차들의 총 대수가 반환된다") {
                totalCarsCount shouldBe 2
            }
        }
    }

    Given("자동차들의 객체가 존재하고") {
        val requestCarList = listOf(
            Car(carName = "현대자동차"),
            Car(carName = "기아자동차")
        )

        val cars = Cars.of(cars = requestCarList)

        When("자동차들 중 첫번째 자동차를 요청하면") {
            val firstCar = cars.getFirstCar()

            Then("첫번째 자동차가 반환된다") {
                firstCar shouldBe Car(carName = "현대자동차")
            }
        }
    }

    Given("만약, 참여하는 자동차들이 없을경우") {
        val requestEmptyCarList = emptyList<Car>()

        When("생성을 요청하면") {
            val carsCreateException = shouldThrow<IllegalArgumentException> {
                Cars.of(cars = requestEmptyCarList)
            }

            Then("예외가 발생한다") {
                carsCreateException.message shouldBe "참여하는 자동차들이 없습니다."
            }
        }
    }
})
