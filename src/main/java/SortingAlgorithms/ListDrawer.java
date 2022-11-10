package SortingAlgorithms;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class ListDrawer {
    private static final ListDrawer listDrawer;
    private Terminal terminal = null;

    static {
        try {
            listDrawer = new ListDrawer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ListDrawer() throws IOException {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        terminal = defaultTerminalFactory.createTerminal();
        terminal.setBackgroundColor(TextColor.ANSI.YELLOW);
    }

    public static ListDrawer create() {
        return listDrawer;
    }

    private void drawLine(int length) throws IOException {
        for (int i = 0; i < length; i++) {
            terminal.putCharacter(' ');
        }
        for (char c : String.valueOf(length).toCharArray())
            terminal.putCharacter(c);
        terminal.putCharacter('\n');
    }

    public void drawList(int[] list) throws IOException, InterruptedException {
        for (int n : list) {
            drawLine(n);
        }
        terminal.flush();
        Thread.sleep(1000);
        terminal.clearScreen();
    }

    public void endTerminal() {
        if (terminal != null) {
            try {
                terminal.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
