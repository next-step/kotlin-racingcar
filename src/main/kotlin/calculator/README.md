# kotlin-racingcar

## 문자열 계산기 구현

### 요구 사항 

- [x] 각 문자열 사이는 공백으로 구분한다
- [x] 사칙연산이 가능하다
    - [x] 더하기
    - [x] 빼기
    - [x] 곱하기
    - [x] 나누기
- [x] 잘못된 입력값은 예외가 발생한다.
  - [x] 입력값이 null 이거나 빈 공백 값이면 IllegalArgumentException을 던진다.
  - [x] 사칙연산 기호 (+,-,*,/)가 아니면 IllegalArgumentException을 던진다.
  - [x] 계산하려는 문자열이 숫자로 변환할 수 없으면 IllegalArgumentException을 던진다.