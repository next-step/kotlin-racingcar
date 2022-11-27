package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinnersTest : StringSpec({

    "우승자 혹은 우승자들의 이름을 반환한다" {
        listOf(
            Cars(listOf(Car.of("자동차A", 1), Car.of("자동차B", 2))) to listOf("자동차B"),
            Cars(listOf(Car.of("자동차A", 2), Car.of("자동차B", 2))) to listOf("자동차A", "자동차B"),
        ).forEach { (racingCars, expected) ->
            val winners = Winners(racingCars)
            winners.names() shouldBe expected
        }
    }
})
