package car.racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class GameRecordsTest : FreeSpec({
    "경기 기록은" - {
        val driverNames = listOf("마루", "벨라", "배추", "여름", "율무")
        val records = GameRecords()

        beforeEach {
            records.reset()
        }

        "기록 횟수에 대하여" - {
            val cars = Cars(driverNames = driverNames)

            "기록횟수를 알 수 있다" {
                val times = 45
                repeat(times) {
                    records.record(cars)
                }
                records.records.size shouldBe times
            }

            "기록은 초기화 할 수 있다" {
                records.record(cars)
                records.reset()
                records.records.size shouldBe 0
            }
        }

        "우승자에 대하여" - {
            "유효한 경기를 했다면 알 수 있다" {
                val cars = Cars(driverNames = driverNames)
                cars.runAll()
                records.record(cars)
                records.winners.size shouldBeGreaterThan 1
            }

            "유효한 경기를 하지 않았다면 알 수 없다" {
                records.winners.size shouldBe 0
            }

            "유효한 경기를 하지 않았다면 기록을 시도했더라도 알 수 없다" {
                val cars = Cars(driverNames = driverNames)
                records.record(cars)
                records.winners.size shouldBe 0
            }
        }
    }
})
