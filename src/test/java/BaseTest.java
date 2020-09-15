import com.demo.modules.sys.vo.StatisticsVO;
import org.junit.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.*;
import java.util.stream.Collectors;

@SpringJUnitConfig
public class BaseTest {

    @Test
    public void test(){
        List<StatisticsVO> list= Arrays.asList(new StatisticsVO().setId("1").setStudentName("1"),new StatisticsVO().setId("2").setStudentName("2"));
        Map<String, List<StatisticsVO>> collect = list.stream().collect(Collectors.groupingBy(vo -> vo.getId()));
        for (Map.Entry<String, List<StatisticsVO>> m : collect.entrySet()) {
            System.out.println(m);
        }
    }
}
