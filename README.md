# kotlin-racingcar

kotlin 학습용 과제로 간단한 자동차 게임을 구현

### 기능 명세
- 사용자에게 경주에 참가하는 자동차들의 이름을 csv 형태로 입력받는다.
- 사용자에게 자동차들이 전진을 시도할 횟수를 입력받는다.
- 각 시도 단계에서 자동차 이름과 함께 현재 위치를 출력한다.
- 입력받은 만큼 전진을 시도한 후, 우승자를 출력해준다.

### Development

- 언어 : kotlin
- test 라이브러리 : JUnit 5
- 코딩 컨벤션은 kotlin 표준을 따름
  - ktlint 를 precommit hook으로 등록하여 스타일을 강제함 
  - [Coding Conventions](https://kotlinlang.org/docs/reference/coding-conventions.html)
  - [Kotlin style guide](https://developer.android.com/kotlin/style-guide)
- 객체지향적 개발을 위해 ThoughtWorks Anthology 의 아래 원칙을 지킨다
  - 한 메서드에 오직 한 단계의 들여쓰기만 한다. 
  - else 예약어를 쓰지 않는다. 
  - 모든 원시 값과 문자열을 포장한다. 
  - 한 줄에 점을 하나만 찍는다. 
  - 줄여 쓰지 않는다(축약 금지). 
  - 모든 엔티티를 작게 유지한다. 
  - 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다. 
  - 일급 컬렉션을 쓴다. 
  - getter/setter/프로퍼티를 쓰지 않는다.