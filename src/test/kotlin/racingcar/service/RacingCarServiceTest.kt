package racingcar.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar

class RacingCarServiceTest : StringSpec({

    "Random 결과값이 4 미만이면 모든 자동차는 전진을 하지 못한다." {
        val cars = List(5) { RacingCar() }
        RacingCarService.race(cars) { 3 }
        cars.forEach {
            it.progress shouldBe 1
        }
    }
})
