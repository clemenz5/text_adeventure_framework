import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalResizeListener;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        try {
            Terminal terminal = factory.createTerminal();
            Screen screen = new TerminalScreen(terminal);


            screen.startScreen();
            screen.setCursorPosition(null);

            Random random = new Random();

            terminal.addResizeListener(new TerminalResizeListener() {
                @Override
                public void onResized(Terminal terminal, TerminalSize terminalSize) {
                    System.out.println(terminalSize);
                    System.out.println(terminalSize.getColumns());
                    System.out.println(terminalSize.getRows());
                    for (int column = 0; column < terminalSize.getColumns(); column++) {
                        for (int row = 0; row < terminalSize.getRows(); row++) {
                            TextGraphics textGraphics = screen.newTextGraphics();

                            textGraphics.setForegroundColor(TextColor.ANSI.BLUE);
                            textGraphics.setBackgroundColor(TextColor.ANSI.values()[random.nextInt(TextColor.ANSI.values().length)]);
                            textGraphics.putString(column, row, "!");
                        }
                    }
                    try {
                        screen.refresh();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
