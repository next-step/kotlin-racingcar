package step3.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import step3.racing.domain.RacingTrack
import step3.racing.util.StubRandomGenerator

class RacingTrackTest : DescribeSpec({
    describe("start") {
        it("레이싱 경주의 히스토리를 저장한다.") {
            val racers = listOf("a", "b", "c")
            val times = 2
            val randomGenerator = StubRandomGenerator(mutableListOf(10, 0, 0, 10, 0, 0))
            val racingTrack = RacingTrack(racers, times, randomGenerator)

            racingTrack.start()

            val allHistory = racingTrack.raceHistory.getAllHistory()
            allHistory.size shouldBe times
            allHistory[0].cars[0].distance shouldBe 1
            allHistory[0].cars[1].distance shouldBe 0
            allHistory[0].cars[2].distance shouldBe 0
            allHistory[1].cars[0].distance shouldBe 2
            allHistory[1].cars[1].distance shouldBe 0
            allHistory[1].cars[2].distance shouldBe 0
        }
    }
})
