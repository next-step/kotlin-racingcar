package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({
    "자동차들이 자동차 수에 맞게 생성된다" {
        val cars = Cars.of(listOf("name1", "name2", "name3"))

        cars shouldHaveSize 3
    }

    "자동차들이 경주하면 모든 자동차가 움직인다" {
        val cars = Cars.of(listOf("name1", "name2", "name3"))

        cars.play(movePolicy = { true })

        cars.forEach {
            it.position shouldBe 1
        }
    }

    "자동차 경주 우승자들을 반환한다" {
        val cars = cars()

        cars.getWinners() shouldContainExactly listOf("name2", "name3")
    }
})

fun cars() = Cars(
    listOf(
        Car(name = "name1", position = 1),
        Car(name = "name2", position = 4),
        Car(name = "name3", position = 4),
    )
)
