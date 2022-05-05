package study.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.describeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import kotlin.time.Duration.Companion.seconds

class StringSpecTest : StringSpec({
    "length 는 문자열의 길이를 반환한다" {
        val s = "hello"
        s.length shouldBe 5
    }

    "startsWith 문자열의 시작을 테스트한다" {
        "world" should startWith("wor")
    }

    // 데이터 기반 테스트, @ParameterizedTest 유사
    "두 숫자 중 최대 값" {
        forAll(
            row(1, 5, 5),
            row(1, 0, 1),
            row(0, 0, 0)
        ) { a, b, max ->
            Math.max(a, b) shouldBe max
        }
    }

    // 테스트 세부 설정
    "테스트 세부 설정".config(timeout = 2.seconds, invocations = 10, threads = 2) {
        // something test...
    }
})