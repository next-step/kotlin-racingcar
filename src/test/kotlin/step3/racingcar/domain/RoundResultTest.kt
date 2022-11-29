package step3.racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe

class RoundResultTest : StringSpec({
    "각 라운드의 경주 결과를 기록하는 객체 생성 시, 현재 시점의 Car 객체 정보를 DeepCopy 한다." {
        val 첫번째_차량 = Car("첫번째 차량", 3)
        val 두번째_차량 = Car("두번째 차량", 2)
        val roundResult = RoundResult()
        roundResult.add(첫번째_차량)
        roundResult.add(두번째_차량)

        roundResult[0] shouldNotBe 첫번째_차량
        roundResult[1] shouldNotBe 두번째_차량
    }
})
