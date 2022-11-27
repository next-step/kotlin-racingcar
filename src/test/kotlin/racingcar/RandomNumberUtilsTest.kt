package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.service.RandomNumberGenerateService

class RandomNumberUtilsTest : FunSpec({
    test("getRandomNumber 함수는 0에서 9사이의 랜덤한 정수를 반환해야 한다.") {
        RandomNumberGenerateService.getRandomNumber() shouldBeInRange 0..9
    }
})
