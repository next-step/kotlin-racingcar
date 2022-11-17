package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({
    given("자동차 게임에서") {
        `when`("가장 많은 거리를 이동한 자동차가") {
            and("한 대 라면") {
                then("findMaxDistanceCars() 리스트의 사이즈는 1이다.") {
                    val cars = Cars(onlyOneMaxDistanceCar)
                    val maxDistanceCar = cars.findMaxDistanceCars()
                    maxDistanceCar.size shouldBe 1
                }
            }

            and("여러 대 라면") {
                then("findMaxDistanceCars() 리스트의 사이즈는 1보다 크다.") {
                    val cars = Cars(multipleMaxDistanceCar)
                    val maxDistanceCar = cars.findMaxDistanceCars()
                    maxDistanceCar.size shouldBeGreaterThan 1
                }
            }

            and("없다면") {
                then("findMaxDistanceCars() 리스트의 사이즈는 0이다.") {
                    val cars = Cars(noOneMaxDistance)
                    val maxDistanceCar = cars.findMaxDistanceCars()
                    maxDistanceCar.size shouldBe 0
                }
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
