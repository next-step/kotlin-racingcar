package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameTest {

    @Test
    fun `사용자 이름은 제약조건을 만족합니다`() {
        val longName = "loongName"
        assertThrows<IllegalArgumentException>("사용자 이름은 최소 한글자 이상 5글자 미만이여야만 합니다. 현재 :0 글자") { CarName("") }
        assertThrows<IllegalArgumentException>("사용자 이름은 최소 한글자 이상 5글자 미만이여야만 합니다. 현재 :${longName.length} 글자") {
            CarName(
                longName
            )
        }
    }
}
