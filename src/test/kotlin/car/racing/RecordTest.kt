package car.racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RecordTest : FunSpec({
    val driverName = "크림"
    val moves = 99
    val record = Record(driverName = driverName, moves = moves)

    test("기록의 드라이버 이름을 가져올 수 있다") {
        record.driverName shouldBe driverName
    }

    test("기록의 이동거리를 가져올 수 있다") {
        record.moves shouldBe moves
    }
})
