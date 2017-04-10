package my.praktikums;
import org.junit.Test;
import org.junit.Assert;


public class FractionTest {

    @Test
    public void  test_SanityTest_JunitWorks() {
        Assert.assertEquals(2, 1+ 1);
    }

    @Test
    public void  test_ConstructorWith2Parameters_Fractions2Parameters() {
        Assert.assertEquals((3 + "/" + 5), new Fraction(3,5).toString());
    }

    @Test
    public void  test_ConstructorWith1Parameter_Fractions2Parameters() {
        Assert.assertEquals((5 + "/" + 1), new Fraction(5).toString());
    }

    @Test
    public void  test_ConstructorWithout_FractionDefault() {
        Assert.assertEquals((0 + "/" + 1), new Fraction().toString());
    }

    @Test
    public void  test_negativeDenominator_negativeNominator() {
        Assert.assertEquals((-3 + "/" + 5), new Fraction(3,-5).toString());
    }

    @Test
    public void  test_negativeConstructor_positiveFraction() {
        Assert.assertEquals((7 + "/" + 5), new Fraction(-7,-5).toString());
    }

    @Test
    public void  test_ConstructorWith2Parameters_negativeFractionFirst() {
        Assert.assertEquals(("-" + 3 + "/" + 5), new Fraction(-3,5).toString());
    }

    private static final double DELTA = 1e-15;

    @Test
    public void  test_ConstructorWith2Parameters_Double() {
        Assert.assertEquals((0.5), new Fraction(1,2).toDouble(),DELTA);
    }

    @Test
    public void  test_ConstructorWith2Parameters_ConstructorFractionInverse() {
        Fraction fraction = new Fraction(2,1);
        Assert.assertEquals((1+"/"+2), fraction.inverse().toString());
    }

    @Test
    public void  test_ConstructorWith2Parameters_isProper() {
        Fraction fractionOne = new Fraction(8,7);
        Fraction fractionTwo = new Fraction(-4,6);

        Assert.assertEquals (false, fractionOne.isProper());
        Assert.assertEquals (true, fractionTwo.isProper());
    }

    @Test
    public void test_Fraction_SimplifiedFraction (){
        Fraction fraction = new Fraction(2,4);
        Assert.assertEquals ((1+"/"+2), fraction.simplify().toString());
    }

    @Test
    public void test_twoFractions_addResult (){
        Fraction fractionOne = new Fraction(1,2);
        Fraction fractionTwo = new Fraction(2,2);
        Fraction fractionThree = new Fraction(4,2);
        Assert.assertEquals ((3+"/"+2), Fraction.add(fractionOne,fractionTwo).simplify().toString());
        Assert.assertEquals ((3+"/"+1), Fraction.add(fractionTwo,fractionThree).simplify().toString());
    }

    @Test
    public void test_twoFractions_subtractResult (){
        Fraction fractionOne = new Fraction(4,2);
        Fraction fractionTwo = new Fraction(3,2);
        Fraction fractionThree = new Fraction(1,2);
        Assert.assertEquals ((1+"/"+2), Fraction.subtract(fractionOne,fractionTwo).simplify().toString());
        Assert.assertEquals ((1+"/"+1), Fraction.subtract(fractionTwo,fractionThree).simplify().toString());
    }

    @Test
    public void test_twoFractions_multiplyResult (){
        Fraction fractionOne = new Fraction(2,4);
        Fraction fractionTwo = new Fraction(3,2);
        Assert.assertEquals ((3+"/"+4), Fraction.multiply(fractionOne,fractionTwo).simplify().toString());
    }

    @Test
    public void test_twoFractions_divideResult (){
        Fraction fractionOne = new Fraction(3,4);
        Fraction fractionTwo = new Fraction(4,5);
        Assert.assertEquals ((15+"/"+16), Fraction.divide(fractionOne,fractionTwo).simplify().toString());
    }
}
