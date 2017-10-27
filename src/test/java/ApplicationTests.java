import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.UnicodeDetector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Author : mastXu
 * Description : saying something
 * Date : 2017/10/26.
 * Modify :
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTests.class)
public class ApplicationTests {

    @Test
    public void hello(){
        System.out.print("hello world----------------------");
    }

    @Test
    public void encodeDetelectorTest() throws IOException {
        File file = new File("C:/Users/admin/Desktop/UTF8.txt");
        System.out.println( file.isFile());

        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
        /* JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码

           测定。所以，一般有了这个探测器就可满足大多数项目的要求*/
        detector.add(JChardetFacade.getInstance());

        // ASCIIDetector用于ASCII编码测定
        detector.add(ASCIIDetector.getInstance());

        // UnicodeDetector用于Unicode家族编码的测定
        detector.add(UnicodeDetector.getInstance());

        Charset ret = detector.detectCodepage(file.toURI().toURL());

        System.out.println(ret.name());
    }


}
