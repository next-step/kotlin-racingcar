package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec() {
    private lateinit var cars: Cars
    private lateinit var maxDistanceCar: List<Car>

    init {
        beforeEach {
            maxDistanceCar = cars.findMaxDistanceCars()
        }

        given("자동차들 중") {
            `when`("가장 먼 거리를 이동한 자동차가 한 대라면") {
                and("한 대 라면") {
                    cars = Cars(onlyOneMaxDistanceCar)

                    then("한 대의 자동차만 리턴된다.") {
                        maxDistanceCar.size shouldBe 1
                    }
                }

                and("여러 대 라면") {
                    cars = Cars(multipleMaxDistanceCar)

                    then("여러 대의 자동차가 리턴된다.") {
                        maxDistanceCar.size shouldBeGreaterThan 1
                    }
                }

                and("없다면") {
                    cars = Cars(noOneMaxDistance)

                    then("0 대의 자동차가 리턴된다.") {
                        maxDistanceCar.size shouldBe 0
                    }
                }
            }
        }
    }

    companion object {
        private const val MAX_DISTANCE = 5
        private const val ZERO = 0

        private val onlyOneMaxDistanceCar = listOf(
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO))
        )
        private val multipleMaxDistanceCar = listOf(
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE)),
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE)),
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE))
        )
        private val noOneMaxDistance = listOf(
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO))
        )
    }
}
