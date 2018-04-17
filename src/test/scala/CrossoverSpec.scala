import org.scalatest._

class CrossoverSpec extends WordSpec with MustMatchers {

  "Crossover" must {

    "return 01, 10 when given 00, 11, 1" in {
      Crossover("00", "11", 1) mustEqual("01", "10")
    }

    "return 10, 01 when given 11, 00, 1" in {
      Crossover("11", "00", 1) mustEqual("10", "01")
    }

    "return 1110, 0001 when given 1111, 0000, 1" in {
      Crossover("1111", "0000", 1) mustEqual("1000", "0111")
    }

    "return 1100, 0011 when given 1111, 0000, 2" in {
      Crossover("1111", "0000", 2) mustEqual("1100", "0011")
    }

    "return 1111, 0000 when given 1111, 0000, 0" in {
      Crossover("1111", "0000", 0) mustEqual("0000", "1111")
    }

    "return 1111, 0000 when given 1111, 0000, 4" in {
      Crossover("1111", "0000", 4) mustEqual("1111", "0000")
    }

    "return 1110000, 0001111 when given 1111111, 0000000, 3" in {
      Crossover("1111111", "0000000", 3) mustEqual("1110000", "0001111")
    }
  }

  "allCombinations" must {

    "return (0,1),(1,0) combinations when given 1,0" in {
    Crossover.allCombinations("1", "0") mustEqual List(("0","1"),("1","0"))
    }

    "return (00,11),(10,01),(11,00) combinations when given 11,00" in {
      Crossover.allCombinations("11", "00") mustEqual List(("00","11"),("10","01"),("11","00"))
    }

    "return all combinations when given 1111111,0000000" in {
      Crossover.allCombinations("1111111", "0000000") mustEqual
        List(("0000000","1111111"), ("1000000","0111111"), ("1100000","0011111"), ("1110000","0001111"),
          ("1111000","0000111"), ("1111100","0000011"), ("1111110","0000001"), ("1111111","0000000"))
    }
  }
}
