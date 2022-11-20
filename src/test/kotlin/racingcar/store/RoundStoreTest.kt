package racingcar.store

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import racingcar.RoundFactory

class RoundStoreTest : FunSpec({
    context("라운드 저장 및 조회 테스트") {
        test("여러 횟수의 라운드를 저장하고 조회할 수 있다.") {
            // given
            val rounds = RoundFactory.createMany(amount = 5)
            // when
            RoundStore.setState(rounds)
            val actual = RoundStore.getState()
            // then
            actual shouldContainExactly rounds
        }
    }
})
