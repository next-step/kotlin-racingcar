package step3.racingcar.view

import org.junit.jupiter.api.Test

class ViewTest {

    @Test
    fun `ResultView 객체를 생성, 입력값 만큼 -를 print한다`() {
        ResultView.showRecordsAsDash(5)
    }
}
