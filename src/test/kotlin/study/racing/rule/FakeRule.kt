package study.racing.rule

import racing.rule.RuleInterface

class FakeRule : RuleInterface {
    override fun isMove(): Boolean = true
}
