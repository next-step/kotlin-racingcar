package carRacing

import carRacing.util.Random
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.shouldBe

class RandomGeneratorTest : FreeSpec({

    "value" - {

        "0 ~ 9 사이의 랜던함 정수 값이 나와야한다." {
            (1..10000).forEach { _ ->
                Random.RandomGenerator().value().shouldBeBetween(0, 9)
            }
        }

        "테스트하려는 값이 나와야한다." {
            withData(
                1 to 1,
                3 to 3,
                5 to 5
            ) { (input, output) ->
                Random.TestRandomGenerator(input).value() shouldBe output
            }
        }
    }
})
