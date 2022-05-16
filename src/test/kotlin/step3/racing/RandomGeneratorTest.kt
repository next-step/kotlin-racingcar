package step3.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

class RandomGeneratorTest : DescribeSpec({
  describe("getInt") {
    it("start 부터 end 까지의 Int 형을 반환한다.") {
      val start = 1
      val end = 2

      val result = RandomGenerator.getInt(start, end)

      result shouldBeGreaterThanOrEqual start
      result shouldBeLessThanOrEqual end
    }
  }
})
