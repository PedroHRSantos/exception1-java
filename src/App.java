import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
        LocalDate data = LocalDate.now();
        LocalDate dataa = LocalDate.parse(sc.next(), formato);
        System.out.println(formato.format(data));
        System.out.println(formato.format(dataa));
        }catch(Exception e){
            System.out.print("lançou uma excessão");
        }

        Long data = new Date().getTime();
        System.out.println("datas " + data);

    }
}
