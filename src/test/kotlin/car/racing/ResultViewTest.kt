package car.racing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe

class ResultViewTest : FreeSpec({
    "결과 화면" - {
        var recordCount = 0
        fun fakeConsole(msg: String) {
            recordCount += 1
        }

        val resultView = ResultView(::fakeConsole)

        "빈 경기결과는 1번 기록되어 있다" {
            recordCount = 0
            resultView.showRecords(GameRecords())
            recordCount shouldBe 1
        }

        "유효한 경기는 1번 이상 기록되어 있다" {
            recordCount = 0
            val drivers = 3
            val cars = Cars(drivers).apply { repeat(10) { runAll() } }
            val records = GameRecords().apply { record(cars) }
            resultView.showRecords(records)
            recordCount shouldBeGreaterThanOrEqual 1
        }
    }
})
