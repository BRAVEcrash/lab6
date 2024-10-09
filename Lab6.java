import java.util.*;
import java.io.*;

public class Lab6 {

    public static void main(String[] args) throws IOException {

        // (문제6-1)
        System.out.println("----(문제6-1)----");
        String solution;
        String s;
        char ch;
        Scanner sc = new Scanner(System.in);

        String[] words = { "java", "count", "school", "student", "computer", "programmer" };
        WordGame wg = new WordGame(words);

        do {
            System.out.print("(1)Word Game, (2)exit: ");
            s = sc.nextLine();
            if(s.charAt(0)=='2') break;
            solution = wg.selectWord();
            StringBuffer answer = new StringBuffer(solution.length());
            for (int i = 0; i < solution.length(); i++)
                answer.append('_');

            while (true) {
                System.out.println("현재의 상태: " + answer);
                System.out.print("글자를 추측하시오: ");
                s = sc.nextLine();
                if (WordGame.check(solution, answer, s.charAt(0)) == true)
                    break;
            }
            System.out.println("현재의 상태: " + answer + "\n");
        } while(true);

        // (문제6-2)
        System.out.println("\n----(문제6-2)----");
        Dice d = new Dice(5);
        for(int i=0; i<10; i++) {
            System.out.println(d.toString());
            d.roll();
        }

        // (문제6-3)
        System.out.println("\n----(문제6-3)----");
        Document doc = new Document();
        int[] counter;

        System.out.print("----------------\n영어 문장을 입력하세요: ");
        s = sc.nextLine();

        String[] wordList = doc.splitWords(s);
        System.out.println("----------------\n단어개수: "+wordList.length+"개");

        System.out.println("----------------");
        counter = doc.countLetters(wordList);
        for(int i=0;i<26; i++) {
            ch = (char)(i+'a');
            System.out.println("문자('" + ch + "')개수: "+counter[i]+"개");
        }

        int total = doc.totalLetters(counter);
        System.out.println("----------------\n글자개수: "+total+"개\n----------------");


        // (문제6-4)
        System.out.println("\n----(문제6-4)----");

        int num2;
        String search;
        String  num, name, tel, email;
        Scanner sc2 = null;
        FileIO fio = new FileIO();

        PrintWriter out = fio.fileOut("user.txt");

        while(true){
            System.out.print("사용자 번호를  입력하세요: ");
            num = sc.next();
            System.out.print("사용자 이름을  입력하세요: ");
            name = sc.next();
            System.out.print("사용자 전화번호를  입력하세요: ");
            tel = sc.next();
            System.out.print("사용자 이메일을  입력하세요: ");
            email= sc.next();
            System.out.print("입력이 끝났으면 1 계속입력하시려면 0: ");
            num2 = sc.nextInt();
            out.print(num + " " + name + " " + tel + " " + email+"\n");
            out.flush();
            if(num2 == 1)
                break;
        }

        System.out.print("검색하실 사용자 번호를 입력하세요: ");
        num2 = sc.nextInt();
        search = num2+"";
        sc2 = fio.fileIn("user.txt");

        while(sc2.hasNext()){
            num = sc2.next();
            name = sc2.next();
            tel = sc2.next();
            email = sc2.next();
            if(num.equals(search))
                System.out.println("사용자 번호 "+num2+"의 전화번호는"+tel +"입니다.");
        }

        if(sc2 !=null)
            sc2.close();
    }
}