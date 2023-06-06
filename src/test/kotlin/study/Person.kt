package study

// kotlin에서는 nullable을 명시해줄 수 있다. suffix에 ?를 붙이면 됨
// class 앞에 data를 붙이면 value object로 사용할 수 있다.
data class Person(val name: String, val age: Int, var nickname: String? = "Guest")
