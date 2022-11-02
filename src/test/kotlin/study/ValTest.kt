package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ValTest : StringSpec() {
    init {
        "var에 다른 타입으로 재할당이 가능한가" {
            var string = "this is string"
//            string = 5 // 불가능함. 타입추론이란 코드에서 타입을 추론해 compile 시점에 타입이 정해짐.

            string shouldBe "this is string"
        }
    }
}
