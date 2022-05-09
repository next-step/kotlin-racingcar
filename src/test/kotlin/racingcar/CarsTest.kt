package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarsTest : DescribeSpec({

    describe("location") {
        it("자동차들의 위치 정보를 제공한다") {
            val cars = Cars(
                listOf(
                    Car(Location(1)),
                    Car(Location(2)),
                    Car(Location(3)),
                )
            )

            cars.location() shouldContainExactly listOf(
                Location(1),
                Location(2),
                Location(3),
            )
        }
    }
})
