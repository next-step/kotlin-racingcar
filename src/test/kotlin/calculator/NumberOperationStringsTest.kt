package calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("문자열 계산기")
class NumberOperationStringsTest : StringSpec({

    "문자열 리스트로 생성 가능" {
        listOf(
            listOf("1"),
            listOf("1", "+", "2"),
            listOf("1", "*", "5"),
        ).forAll {
            shouldNotThrowAny {
                NumberOperationStrings(it)
            }
        }
    }

    "문자열은 공백일 수 없음" {
        listOf(
            listOf(""),
            listOf("1", "", "2"),
        ).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                NumberOperationStrings(it)
            }
        }
    }

    "숫자와 연산자 문자열들의 개수는 반드시 홀수여야 함" {
        listOf(
            emptyList(),
            listOf("1", "+"),
        ).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                NumberOperationStrings(it)
            }
        }
    }

    "숫자 문자열들의 사칙 연산을 수행할 수 있음" {
        listOf(
            NumberOperationStrings(listOf("2", "+", "3", "*", "4", "/", "2")) to 10,
            NumberOperationStrings(listOf("5", "-", "1", "/", "2", "+", "3", "*", "3")) to 15
        ).forAll {
            it.first.calculatedNumber shouldBe it.second
        }
    }
})
