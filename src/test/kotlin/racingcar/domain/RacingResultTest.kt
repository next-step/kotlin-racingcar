package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class RacingResultTest : StringSpec({

    "경주 완료 전에는 우승자를 알 수 없다." {
        val cars = listOf(
            Car("자동차1", position = 2),
            Car("자동차2", position = 5)
        )

        val racingResult = RacingResult(cars, false)
        shouldThrow<IllegalStateException> { racingResult.winners() }
    }

    "경주 완료 후 우승자를 알려 준다. 우승자는 1명 이상 일 수 있다." {
        val cars = listOf(
            Car("자동차1", position = 2),
            Car("자동차2", position = 5),
            Car("자동차3", position = 1),
            Car("자동차4", position = 4),
            Car("자동차5", position = 5)
        )

        val racingResult = RacingResult(cars, true)
        racingResult.winners().size shouldBe 2
        racingResult.winners() shouldContain Car("자동차2", position = 5)
        racingResult.winners() shouldContain Car("자동차5", position = 5)
    }
})
