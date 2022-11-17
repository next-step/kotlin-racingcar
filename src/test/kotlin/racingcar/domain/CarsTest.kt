package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({
    given("자동차들이") {
        `when`("경기를 진행했을 때") {
            then("가장 많은 거리를 간 자동차는 한 대 뿐이다.") {
                val cars = Cars(onlyOneMaxDistanceCar)
                val maxDistanceCar = cars.findMaxDistanceCars()
                maxDistanceCar.size shouldBe 1
            }

            then("가장 많은 거리를 간 자동차는 여러 대이다.") {
                val cars = Cars(multipleMaxDistanceCar)
                val maxDistanceCar = cars.findMaxDistanceCars()
                maxDistanceCar.size shouldBeGreaterThan 1
            }

            then("가장 많은 거리를 간 자동차는 없다.") {
                val cars = Cars(noOneMaxDistance)
                val maxDistanceCar = cars.findMaxDistanceCars()
                maxDistanceCar.size shouldBe 0
            }
        }
    }
}) {
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
