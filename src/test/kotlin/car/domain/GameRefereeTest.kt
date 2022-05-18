package car.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class GameRefereeTest : FunSpec({
    context("경기 심판은") {
        test("단일 우승자를 반환한다") {
            val records = listOf(Record("크림", 0), Record("히어로즈", 1))
            val winners = GameReferee.getWinners(records)

            winners.size shouldBe 1
            winners.first().driverName shouldBe "히어로즈"
        }
        test("공동 우승자를 반환한다") {
            val records = listOf(Record("크림", 2), Record("히어로즈", 2))
            val winners = GameReferee.getWinners(records)

            winners.size shouldBe 2
            winners shouldContainAll records
        }
        test("경기 기록이 없다면 빈 우승자 목록을 반환한다") {
            val winners = GameReferee.getWinners(emptyList())

            winners.size shouldBe 0
        }
        test("이동거리가 모두 0인 경기기록이 있다면 빈 우승자 목록을 반환한다") {
            val records = listOf(Record("크림", 0), Record("히어로즈", 0))
            val winners = GameReferee.getWinners(records)

            winners.size shouldBe 0
        }
    }
})
