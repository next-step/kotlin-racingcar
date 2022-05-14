package car_racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RandomNumberCarRacingManagerTest : StringSpec({

    "getMonitoringInformation 는 자동차 경주 디스플레이하기 위한 데이터를 넘겨준다" {
        // given
        val carDistances = listOf(1, 3, 4)
        val randomNumberCarRacingManager = createTestCarRacingManager(carDistances)
        val monitoringValue = """--
----
-----"""

        // when
        val monitoringResult = randomNumberCarRacingManager.getMonitoringInformation()

        // then
        monitoringResult shouldBe monitoringValue
    }

    "getMonitoringFormatBy 거리를 기준으로 디스플레이 용 데이터를 내보낸다" {
        // given
        val distance = 10

        // when
        val monitoringFormat = RandomNumberCarRacingManager.getMonitoringFormatBy(distance)

        // then
        monitoringFormat.length shouldBe distance + 1
        monitoringFormat shouldBe "-----------"
    }

    "isForwardNumber 는 랜덤 숫자를 기준으로 전진해야하는 숫자인지 판별한다" {
        // given
        val randomNumber = 4

        // when
        val isForward = RandomNumberCarRacingManager.isForwardNumber(randomNumber)

        // then
        isForward shouldBe true
    }

    "4미만의 랜덤 숫자는 전진 할수 없다" {
        // given
        val randomNumber = 1

        // when
        val isForward = RandomNumberCarRacingManager.isForwardNumber(randomNumber)

        // then
        isForward shouldBe false
    }

    "tryMoveCar 는 자동차 번호, 랜덤 숫자를 받아 전진 여부를 설정해준다" {
        // given
        val forwardRandomNumber = 4
        val randomNumberCarRacingManager = RandomNumberCarRacingManager(InputDto("1", "0"))

        // when
        randomNumberCarRacingManager.tryMoveCar(0, forwardRandomNumber)

        // then
        randomNumberCarRacingManager.cars[0].distance shouldBe 1
    }

    "tryMoveCar 는 전진할수 없는 랜덤 숫자를 받으면 전진하지 않는다" {
        // given
        val stopRandomNumber = 1
        val randomNumberCarRacingManager = RandomNumberCarRacingManager(InputDto("1", "0"))

        // when
        randomNumberCarRacingManager.tryMoveCar(0, stopRandomNumber)

        // then
        randomNumberCarRacingManager.cars[0].distance shouldBe 0
    }
})

private fun createTestCarRacingManager(carDistances: List<Int>): RandomNumberCarRacingManager {
    val randomNumberCarRacingManager = RandomNumberCarRacingManager(InputDto("${carDistances.size}", "0"))
    for ((index: Int, distance: Int) in carDistances.withIndex()) {
        randomNumberCarRacingManager.cars[index].distance = distance
    }
    return randomNumberCarRacingManager
}
