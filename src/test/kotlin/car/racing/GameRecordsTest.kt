package car.racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GameRecordsTest : FreeSpec({
    "경기 기록은" - {
        val drivers = 3
        val cars = Cars(drivers)
        val records = GameRecords()

        beforeEach {
            records.reset()
        }

        "기록횟수를 알 수 있다" {
            records.record(cars)
            records.records.size shouldBe 1
        }

        "기록은 초기화 할 수 있다" {
            records.record(cars)
            records.reset()
            records.records.size shouldBe 0
        }
    }
})
