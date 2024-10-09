import java.io.*;
import java.util.*;

public class FileIO {

    // 파일에 출력할 PrintWriter 객체를 반환
    public PrintWriter fileOut(String name) throws IOException {
        // BufferedWriter와 FileWriter를 사용해 파일에 데이터를 이어서 기록
        return new PrintWriter(new BufferedWriter(new FileWriter(name, true)));
    }

    // 파일을 읽을 Scanner 객체를 반환
    public Scanner fileIn(String name) throws IOException {
        // 파일을 읽기 위해 Scanner를 반환, 파일이 없으면 FileNotFoundException 발생
        return new Scanner(new File(name));
    }
}
