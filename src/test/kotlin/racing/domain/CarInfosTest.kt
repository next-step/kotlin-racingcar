package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarInfosTest : StringSpec() {
    init {
        "가지고 있는 CarInfo 중에 최고 Position 을 찾을 수 있다" {
            val carInfos = CarInfos(listOf(
                CarInfo("kim", Position(1)),
                CarInfo("ko", Position(3)),
                CarInfo("rong", Position(2)))
            )

            val maxPosition = carInfos.findMaxPosition()

            maxPosition shouldBe Position(3)
        }
    }
}
