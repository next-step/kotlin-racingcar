package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CarsKoTest : StringSpec({
    "주어진 개수만큼 자동차 객체가 생성되어야한다" {
        val cars = Cars(3)
        cars.countCars() shouldBe 3
    }

    "시도 후 점수가 달라져야한다." {
        val cars = Cars(3)
        val before = cars.scores
        for (i in 0..4) {
            cars.attempt()
        }
        val after = cars.scores
        after shouldNotBe before
    }
})
