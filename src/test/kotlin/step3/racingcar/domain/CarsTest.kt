package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : BehaviorSpec({
    given("경주를 완료한 자동차 객체 목록이 주어지고") {
        val 첫_번째_차량 = Car("첫 번째 차량", 2)
        val 두_번째_차량 = Car("두 번째 차량", 3)
        val 세_번째_차량 = Car("세 번째 차량", 3)

        `when`("우승자 객체를 생성하면") {
            val 참가_차량_목록 = listOf(첫_번째_차량, 두_번째_차량, 세_번째_차량)
            val given = Cars.of(참가_차량_목록)
            then("우승한 차량들의 이름을 반환한다.") {
                given.winnerNames() shouldBe "두 번째 차량, 세 번째 차량"
            }
        }
    }
})
