package car.view

import car.domain.Cars
import car.domain.GameRecords
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe

@Suppress("UNUSED_PARAMETER")
class ResultViewTest : FreeSpec({
    "결과 화면" - {
        var consolePrintCount = 0
        fun fakeConsole(msg: String) {
            consolePrintCount += 1
        }

        val resultView = ResultView(::fakeConsole)

        beforeEach {
            consolePrintCount = 0
        }

        "빈 경기결과는 유효한 경기 기록이 없다는 메시지 표시를 위해 한번 [Console]을 호출한다" {
            resultView.showRecords(GameRecords())
            consolePrintCount shouldBe 1
        }

        "유효한 경기는 기록 및 우승자 표시를 위해 한번 이상 [Console]을 호출한다" {
            val driverNames = listOf("크림", "히어로")
            val moves = 10
            val cars = Cars(driverNames).apply { repeat(moves) { runAll() } }
            val records = GameRecords().apply { record(cars) }
            resultView.showRecords(records)
            consolePrintCount shouldBeGreaterThanOrEqual 1
        }
    }
})
