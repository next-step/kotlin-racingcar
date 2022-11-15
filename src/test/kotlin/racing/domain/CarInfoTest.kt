package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarInfoTest : StringSpec() {
    init {
        "CarInfo 는 compareTo 를 사용할 수 있다" {
            val carInfo1 = CarInfo("ko", Position(1))
            val carInfo2 = CarInfo("rong", Position(2))

            carInfo1.compareTo(carInfo2) shouldBe -1
            carInfo1.compareTo(carInfo1) shouldBe 0
            carInfo2.compareTo(carInfo1) shouldBe 1
        }
    }
}
