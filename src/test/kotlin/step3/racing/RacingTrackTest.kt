package step3.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class RacingTrackTest : DescribeSpec({

  describe("생성") {
    it("생성시 racerCount 만큼 Car 를 생성한다. ") {
      val racerCount = 4

      val racingTrack = RacingTrack(racerCount, 3)

      racingTrack.racers.also {
        it.size shouldBe racerCount
        it.map { car ->
          car.shouldBeInstanceOf<Car>()
        }
      }
    }
  }
})
