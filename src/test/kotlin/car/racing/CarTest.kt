package car.racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({
    val driverName = "크림"
    "자동차는" - {
        "드라이버 이름을 가져올 수 있다" {
            val car = Car(driverName)
            car.driverName shouldBe driverName
        }

        "드라이버 이름 비어 있다면 IllegalArgumentException 발생" {
            shouldThrowExactly<IllegalArgumentException> {
                Car("")
            }
        }

        "앞으로 이동할 수 있다" {
            val car = Car(driverName)
            repeat(10) {
                car.run()
            }
            car.moves shouldBeGreaterThanOrEqual 0
        }

        "차량 상태가 좋은경우 시도횟수와 동일하게 앞으로 이동할 수 있다" {
            val car = Car(driverName, CarCondition.GOOD)
            val trying = 10
            repeat(trying) {
                car.run()
            }
            car.moves shouldBe trying
        }
        "차량 상태가 나쁜경우 앞으로 이동하지 못한다" {
            val car = Car(driverName, CarCondition.TERRIBLE)
            val trying = 10
            repeat(trying) {
                car.run()
            }
            car.moves shouldBe 0
        }
    }
})
