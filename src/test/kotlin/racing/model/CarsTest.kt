package racing.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : DescribeSpec({
    describe("Cars 테스트") {
        it("자동차 이름들을 가진 생성할 수 있다.") {
            // given
            val names = listOf("mbc", "kbs", "jtbc", "sbs")

            // when
            val cars = Cars.createWithNames(names)

            // then
            cars.size() shouldBe 4
        }
    }
})
