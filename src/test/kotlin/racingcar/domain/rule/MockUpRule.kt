package racingcar.domain.rule

import racingcar.domain.CarMovementRule

class MockUpRule : CarMovementRule {
    var hasBeenCalled = false
    override val rule = {
        hasBeenCalled = true
        true
    }
}
