package carracing.model.model

class Car {
    var moveCountInRacing: Int = 0
    fun move(rule: Rule) {
        if (rule.isMoveAllowed()) {
            moveCountInRacing++
        }
    }
}
