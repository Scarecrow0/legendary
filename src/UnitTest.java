import model.Lexer;
import model.Parser;
import model.SyntaxHighlighter;
import model.TokenManager;

public class UnitTest {
    public static void main(String[] args) {
        try {
            String raw_code = "CSEG SEGMENT\n" +
                    "START:\n" +
                    "MOV AH, 01H ;ASSUME CS:CSEG\n" +
                    "INT 21H\n" +
                    "\n" +
                    "\n" +
                    "add ax,51h\n" +
                    "CMP AL, 0\n" +
                    "JB OTHER\n" +
                    "mov ax,axddd\n" +
                    "mov ax,56465 ;sdfasfdasdf\n" +
                    "mov ax,bx\n" +
                    "CMP AL, 9\n" +
                    "JBE NUM ; '0'~'9' IS NUMBER\n" +
                    "CMP AL, 455\n" +
                    "OTHER:\n" +
                    "JB OTHER\n" +
                    "CMP AL, BL\n" +
                    "add ax, 455\n" +
                    "JBE ALPHA ; 'A'~'Z'IS ALPHABET\n" +
                    "CMP AL, 56;dfasdf\n" +
                    "JB OTHER\n" +
                    "CMP AL, 11H ; 'a'~'z'\n" +
                    "JBE ALPHA\n" +
                    "JMP OTHER\n" +
                    "NUM:\n" +
                    "MOV DL, 0abh\n" +
                    "JMP OUTPUT\n" +
                    "ALPHA:\n" +
                    "MOV DL, 652h\n" +
                    "MOV AX, BX\n";
            Lexer.getInstance().generateToken(raw_code);
            Parser.getInstance().parse();
            SyntaxHighlighter.getInstance().startHighlighting();
            System.out.println(raw_code);
            System.out.println(TokenManager.getInstance().toString());
        } catch (Exception ee) {

        }
    }
}
