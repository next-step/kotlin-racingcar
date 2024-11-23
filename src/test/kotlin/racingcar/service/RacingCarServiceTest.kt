package racingcar.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
import racingcar.model.Forward
import racingcar.model.RacingCar
import racingcar.model.TryCount
import racingcar.model.Winner
import racingcar.view.ResultView

class RacingCarServiceTest : StringSpec({
    "getRacingCars test - 사용자 입력 리스트로 반환" {
        val tryCount = mockk<TryCount>()
        val forward = mockk<Forward>()

        val service = RacingCarService(tryCount, forward)

        mockkStatic("kotlin.io.ConsoleKt")
        every { readln() } returns "kim,da,bo,mi"

        val result = service.readRacingCarNames("kim,da,bo,mi")

        result shouldBe listOf("kim", "da", "bo", "mi")
    }

    "startTryCount test - 검증된 시도 횟수 반환" {
        val tryCount = mockk<TryCount>()
        val forward = mockk<Forward>()

        val service = RacingCarService(tryCount, forward)

        mockkStatic("kotlin.io.ConsoleKt")
        every { readln() } returns "10"

        every { tryCount.getTryCount(any()) } answers { firstArg() }

        val result = service.readTryCount(10)

        result shouldBe 10
    }

    "startRace test - 레이싱 결과 반환" {
        val tryCount = mockk<TryCount>()
        val forward = mockk<Forward>()

        val service = RacingCarService(tryCount, forward)

        every { forward.pickRandomNumberInRange() } returnsMany listOf(4, 5, 3, 4, 5, 6)

        val racingCars = listOf("kim", "da", "bo", "mi")
        val tryCountValue = 3
        val raceCars = service.runRace(racingCars, tryCountValue)

        raceCars[0].position shouldBe 3
        raceCars[1].position shouldBe 3
        raceCars[2].position shouldBe 2
        raceCars[3].position shouldBe 3
    }

    "startWinner test - 우승자 출력" {
        val tryCount = mockk<TryCount>()
        val forward = mockk<Forward>()

        val service = RacingCarService(tryCount, forward)

        val racingCars =
            listOf(
                RacingCar("kim", 4),
                RacingCar("da", 4),
                RacingCar("bo", 3),
                RacingCar("mi", 2),
            )

        mockkObject(Winner)
        mockkObject(ResultView)

        every { Winner.determineWinners(racingCars) } returns listOf("kim", "da")

        val result = service.determineWinners(racingCars)

        result shouldBe listOf("kim", "da")
    }
})
