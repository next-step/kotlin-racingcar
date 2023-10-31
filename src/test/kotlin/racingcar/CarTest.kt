package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import kotlin.random.Random

class CarTest : StringSpec({
    beforeTest {
        mockkObject(Random)
    }
    afterTest {
        unmockkObject(Random)
    }


    "전진하는 조건을 만족하면 자동차는 전진한다. " {
        val car = Car.create()
        every { Random.nextInt(Car.getRandomRange()) } returns Car.getMoveThreshold()

        car.move()

        car.display() shouldBe "-"
    }

    "전진하는 조건을 만족하지 못하면 자동차는 전진하지 않는다" {
        val car = Car.create()
        every { Random.nextInt(Car.getRandomRange()) } returns Car.getMoveThreshold() - 1

        car.move()

        car.display() shouldBe ""
    }
})
