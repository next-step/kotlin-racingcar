package racingcar.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import racingcar.RoundStore

class RoundInputComponentTest : FunSpec({
    context("커멘드 이벤트 리스너 테스트") {
        context("라운드 횟수 입력 이벤트가 발생하면") {
            test("입력한 횟수만큼 라운드를 생성하고 스토어에 저장한다.") {
                val sut = RoundInputComponent()
                // when
                sut.onCommand("3")
                // then
                val actual = RoundStore.findAll()
                actual shouldHaveSize 3
            }
        }
    }
})
