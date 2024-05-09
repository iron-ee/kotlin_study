package main.kotlin.fp.method

// 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우

inline fun Int.add3(other: Int): Int {
    return this + other
}

fun main() {
    3.add3(5)
}

/*
바이트 코드로
   public static final void main() {
      byte $this$add3$iv = 3;
      int other$iv = 5;
      int $i$f$add3 = false;
      int var10000 = $this$add3$iv + other$iv;   -> 함수를 호출하는게 아니라 덧셈하는 로직 자체가 그 함수를 부르는 쪽에 복사 붙여넣기가 됨
   }
 */

/*
그럼 이 inline 을 왜 사용할까

함수를 파라미터로 전달할 때에 오버헤드를 줄일 수 있다.
-> 함수를 계속 중첩해서 쓰는 경우에는 이 함수가 다시 또 다른 함수를 부르고 또 다른 함수를 부르다 보면
call chain 에 overhead 가 생기다 보니 이것을 줄이기 위해서 inline 이라는 것을 사용
하지만, inline 함수의 사용은 성능 측정과 함께 신중하게 사용해야 함
kotlin 에서는 적절하게 inline 함수를 사용해 구현되어 있기 때문에 최적화가 잘 되어있음.
 */