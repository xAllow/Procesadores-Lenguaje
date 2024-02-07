import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LLPLXC {

    public static PrintStream out;
    
    public static void main(String args[]) {
        try {
            Reader in = new InputStreamReader(System.in);
            out = System.out;
            
            if (args.length > 0) {
                in = new FileReader(args[0]);
            }
            
            if (args.length > 1) {
                out = new PrintStream(new FileOutputStream(args[1]));
            }
            LLPLXC.out.println("@.str = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\", align 1\n" + //
                                "declare i32 @printf(i8*, ...)\n" + //
                                "declare void @exit(i32 noundef)\n" + //
                                "define i32 @main() {");
            parser p = new parser(new Yylex(in));
            Object result = p.parse().value;
            LLPLXC.out.println("  ret i32 0");
            LLPLXC.out.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}