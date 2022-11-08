package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class HeadKtTest : FunSpec({
    context("head 함수는") {
        context("리스트를 입력하면") {
            test("첫번째 요소와 나머지 요소를 Pair 로 반환한다.") {
                // given
                val list = listOf(1, 3, 5, 7, 9)
                // when
                val (head: Int, rest: List<Int>) = head(list)
                // then
                head shouldBe 1
                rest shouldContainExactly listOf(3, 5, 7, 9)
            }
        }
    }
})
