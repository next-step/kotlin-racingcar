package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarNameSplitterTest : FunSpec({
    context("자동차 이름 구분 테스트") {
        context("여러 개의 자동차 이름을 문자열로 입력하면") {
            test("쉼표를 기준으로 자동차 이름을 구분한다.") {
                // given
                val 자동차_이름_문자열 = "pobi, honux, relkimm, seulgeun"
                // when
                val actual = CarNameSplitter.execute(target = 자동차_이름_문자열)
                // then
                actual shouldBe listOf("pobi", "honux", "relkimm", "seulgeun")
            }
        }
    }
})
