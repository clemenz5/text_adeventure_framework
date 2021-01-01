import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        try{
            new SwingTerminal().
            Terminal terminal = factory.createTerminalEmulator();
            Screen screen = new TerminalScreen(terminal);

            screen.startScreen();
            screen.setCursorPosition(null);

            terminal.setForegroundColor(TextColor.ANSI.RED);
            terminal.setBackgroundColor(TextColor.ANSI.BLUE);

            terminal.putCharacter('d');
            terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
            terminal.setBackgroundColor(TextColor.ANSI.DEFAULT);
            terminal.flush();



            Random random = new Random();
            TerminalSize terminalSize = screen.getTerminalSize();
            for(int column = 0; column < terminalSize.getColumns(); column++) {
                for(int row = 0; row < terminalSize.getRows(); row++) {
                    screen.setCharacter(column, row, new TextCharacter(
                            '#',
                            TextColor.ANSI.BLUE,
                            // This will pick a random background color
                            TextColor.ANSI.values()[random.nextInt(TextColor.ANSI.values().length)]));
                }
            }
            terminal.flush();
            screen.refresh();

        }catch (Exception e){

        }
    }
}
