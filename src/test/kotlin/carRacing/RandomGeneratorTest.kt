package carRacing

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.ints.shouldBeBetween

class RandomGeneratorTest : FreeSpec({

    "value" - {

        "0 ~ 9 사이의 랜던함 정수 값이 나와야한다." {
            (1..10000).forEach { _ ->
                RandomGenerator.value().shouldBeBetween(0, 9)
            }
        }
    }
})
