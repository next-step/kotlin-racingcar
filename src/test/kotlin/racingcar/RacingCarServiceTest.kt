package racingcar

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class RacingCarServiceTest : StringSpec({
    "사용자 입력에 따라 수행을 반복합니다." {
        val mockInputProvider = mockk<InputProvider>()
        val mockResultProvider = mockk<ResultProvider>()

        every { mockInputProvider.getIntInput("자동차 대수는 몇 대 인가요?") } returns 2
        every { mockInputProvider.getIntInput("시도할 횟수는 몇 회 인가요?") } returns 3

        val sut = RacingCarService(mockInputProvider, mockResultProvider)
        sut.run()

        verify(exactly = 3) { mockResultProvider.printItems(any<List<Car>>()) }
    }
})
