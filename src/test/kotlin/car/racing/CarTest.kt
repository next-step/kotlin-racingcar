package car.racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({
    "자동차들은" - {
        "드라이버의 수만큼 이동거리를 알 수 있다" {
            val drivers = 199
            val cars = Cars(drivers = drivers)
            cars.runAll()
            cars.getAllMoves().size shouldBe drivers
        }
        "한번도 이동하지 않으면 모두 이동거리가 0이다" {
            val cars = Cars(drivers = 10)
            cars.getAllMoves().all { it == 0 } shouldBe true
        }
    }
})
