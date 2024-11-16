package racingcar.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import racingcar.model.Forward
import racingcar.model.TryCount

class RacingCarServiceTest : StringSpec({

    "startNumberCars test - 사용자 입력 정수로 반환" {
        val service = RacingCarService()
        mockkStatic("kotlin.io.ConsoleKt")
        every { readln() } returns "5"

        val result = service.startNumberCars()

        result shouldBe 5
    }

    "startTryCount test - 검증된 시도 횟수 반환" {
        val mockTryCount = mockk<TryCount>()
        val service = RacingCarService().apply { tryCount = mockTryCount }

        mockkStatic("kotlin.io.ConsoleKt")
        every { readln() } returns "10"

        every { mockTryCount.getTryCount(any()) } answers { firstArg() }

        val result = service.startTryCount()

        result shouldBe 10
    }

    "startRace test - 레이싱 결과 반환" {
        val mockForward = mockk<Forward>()
        val service = RacingCarService().apply { forward = mockForward }

        every { mockForward.pickRandomNumberInRange() } returnsMany listOf(4, 5, 3, 4, 5, 6)

        val numberCars = 2
        val tryCount = 3
        val raceCars = service.startRace(numberCars, tryCount)

        raceCars[0].position shouldBe 2
        raceCars[1].position shouldBe 3
    }
})
