package racing.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class CarTokenizerTest : StringSpec({

    "자동차 이름은 쉼표(,)를 기준으로 구분한다" {
        val actual = CarTokenizer.tokenize("하나,둘,셋,넷")
        actual shouldHaveSize 4
    }
})
