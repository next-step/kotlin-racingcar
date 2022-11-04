package study.step2

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import org.assertj.core.api.Assertions.assertThat

class OperatorEnumTest : StringSpec({
    "주어진 operator 가 enum 의 operator 과 같은게 존재하면 true 를 반환한다" {
        listOf("+", "-", "*", "/")
            .forAll {
                assertThat(OperatorEnum.exist(it)).isTrue()
            }
    }

    "주어진 operator 가 enum 의 operator 과 같은게 존재하지 않으면 false 를 반환한다" {
        listOf("A", "!", "$", "=")
            .forAll {
                assertThat(OperatorEnum.exist(it)).isFalse()
            }
    }
})
