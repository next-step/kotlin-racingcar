package study

import Car
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class CardKoTest : StringSpec({
    "랜덤값" {
        val car = Car()
        for(i in 0..10) {
            car.getRandomInt() shouldBeInRange 0..9
        }
    }
    "움직임 여부" {
        var car = Car()
        car.checkCanGo() shouldBe true
    }

    "차 이동" {
        var car = Car()
        for(i in 0 until 5) {
            println(car.getCarProgress())
        }
    }

})