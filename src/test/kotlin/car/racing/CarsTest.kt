package car.racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarsTest : FreeSpec({
    val driverNames = listOf("크림", "히어로")
    "자동차들은" - {
        "드라이버의 수만큼 이동거리를 알 수 있다" {
            val cars = Cars(driverNames = driverNames)
            cars.runAll()
            cars.getAllRecord().size shouldBe driverNames.size
        }
        "한번도 이동하지 않으면 모두 이동거리가 0이다" {
            val cars = Cars(driverNames = driverNames)
            cars.getAllRecord().all { it.moves == 0 } shouldBe true
        }
    }
})
