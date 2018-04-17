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
}
