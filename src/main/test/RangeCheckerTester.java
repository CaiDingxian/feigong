import com.voidgeek.feigong.checker.impl.RangeChecker;
import org.junit.Test;

public class RangeCheckerTester {


    @Test
    public void doTest()
    {
        RangeChecker rangeChecker=new RangeChecker(10,15,true,true,true);
        System.out.println(rangeChecker.check(9).isOk());
        System.out.println(rangeChecker.check(15).isOk());
    }

}
