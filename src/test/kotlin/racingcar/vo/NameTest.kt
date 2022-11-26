package racingcar.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

internal class NameTest : FunSpec({
    context("객체 생성") {
        test("이름이 1자 이상, 5자 이하일 경우, 객체가 생성된다.") {
            listOf("1", "12345").forAll {
                shouldNotThrowAny {
                    Name(it)
                }
            }
        }

        test("공백 또는 5자 초과일 경우, IllegalArgumentException 예외가 발생한다.") {
            listOf("", " ", "123456").forAll {
                val actual = shouldThrow<IllegalArgumentException> {
                    Name(it)
                }

                actual.message should startWith("name length should be between ")
            }
        }
    }
})
