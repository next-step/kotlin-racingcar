package racing.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingCarServiceTest : FunSpec({

    lateinit var racingCarService: RacingCarService
    beforeTest {
        racingCarService = RacingCarService()
    }

    test("레이싱 게임 준비 동작 확인") {
        // Given
        val carNames = "pobi,crong,honux".split(",")

        // When
        val cars = racingCarService.prepareRacingGame(carNames)

        // Then
        cars.size shouldBe 3
        cars[0].name shouldBe "pobi"
        cars[0].position shouldBe 0
    }

    test("레이싱 게임 시작 동작 확인") {
        // Given
        val carNames = "pobi,crong,honux".split(",")
        val cars = racingCarService.prepareRacingGame(carNames)

        // When
        val racingCars = racingCarService.startRacingGame(cars)

        // Then
        racingCars.size shouldBe 3
    }
})
