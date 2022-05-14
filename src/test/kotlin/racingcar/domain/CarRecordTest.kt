package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldNotBe

internal class CarRecordTest : DescribeSpec({

    describe("of") {
        it("자동차 객체를 통해 자동차 기록을 만들 수 있다.") {
            val carRecord = CarRecord.of(Car())
            carRecord shouldNotBe null
        }
    }
})
