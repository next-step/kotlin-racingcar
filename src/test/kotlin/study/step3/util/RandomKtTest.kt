package study.step3.util

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat

class RandomKtTest : StringSpec({

    "주어진 랜덤숫자함수를, 호출하면, 0~9 사이의 숫자가 반환된다" {
        val intRange = 0..9
        (1..100).forEach { _ ->
            assertThat(randomDigit() in intRange).isTrue()
        }
    }
})
