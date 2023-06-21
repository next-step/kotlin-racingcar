package step3.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CarMakerTest {
    @Test
    fun `이름 리스트를 전달하면 이름을 갖는 자동차들을 생성한다`() {
        //given
        val nameList = listOf("pobi", "crong", "honux")
        val carMaker = CarMaker(nameList, RandomCarMovable())

        //when
        val cars = carMaker.createCars()

        //then
        for (car in cars) {
            Assertions.assertTrue(car.name in nameList)
        }
    }
}