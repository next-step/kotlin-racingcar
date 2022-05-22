package step3.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import step3.racing.domain.Car

class CarTest : DescribeSpec({
    describe("run") {
        it("1~4 사이의 값이 입력되면 이동하지 않는다.") {
            forAll(
                row(0),
                row(1),
                row(2),
                row(3),
            ) { input ->
                val car = Car("name")

                car.run(input)

                car.distance shouldBe 0
            }
        }

        it("4~10 사이의 값은 이동한다.") {
            forAll(
                row(4),
                row(5),
                row(6),
                row(7),
                row(8),
                row(9),
                row(10),
            ) { input ->
                val car = Car("name")

                car.run(input)

                car.distance shouldBe 1
            }
        }
    }
})
