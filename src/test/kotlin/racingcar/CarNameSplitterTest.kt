package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarNameSplitterTest : FunSpec({
    context("자동차 이름을 구분하는 기능 테스트") {
        context("여러 개의 자동차 이름을 문자열로 입력하면") {
            test("쉼표를 기준으로 자동차 이름을 구분한다.") {
                // given
                val 자동차_이름_문자열 = "동구, 재혁, 상근, 주덕"
                // when
                val actual = CarNameSplitter.execute(target = 자동차_이름_문자열)
                // then
                actual shouldContainExactly listOf(
                    CarName(value = "동구"), CarName(value = "재혁"),
                    CarName(value = "상근"), CarName(value = "주덕"),
                )
            }
        }
    }
})
