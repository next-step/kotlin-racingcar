package racingcar.common

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange

class RandomCommandGeneratorSpecs : DescribeSpec({

    describe("랜덤 명령 생성기는") {
        it("0과 9 사이 임의의 숫자를 제공한다") {
            repeat(100) {
                val command = RandomDigitGenerator.nextCommand()
                command shouldBeInRange RandomDigitGenerator.DIGIT_RANGE
            }
        }
    }
})
