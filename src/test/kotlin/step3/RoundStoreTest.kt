package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class RoundStoreTest : FunSpec({
    context("라운드 저장 테스트") {
        val sut = RoundStore
        test("여러 횟수의 라운드를 저장할 수 있다.") {
            // given
            val rounds = RoundFactory.createMany(amount = 5)
            // when
            val actual = sut.saveAll(rounds)
            // then
            actual shouldContainExactly rounds
        }
    }

    context("라운드 조회 테스트") {
        val sut = RoundStore
        test("여러 횟수의 라운드를 조회할 수 있다.") {
            // given
            val rounds = RoundFactory.createMany(amount = 5)
            sut.saveAll(rounds)
            // when
            val actual = sut.findAll()
            // then
            actual shouldContainExactly rounds
        }
    }
})
