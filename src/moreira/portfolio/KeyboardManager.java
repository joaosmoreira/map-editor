package moreira.portfolio;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager {
    public static void initKeyEvents (KeyboardHandler handler) {
        Keyboard kb = new Keyboard(handler);
        for (Key k : Key.values()) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(k.type);
            event.setKey(k.keyNum);
            kb.addEventListener(event);
        }
    }

    private enum Key {
        /* Movement */
        UP_PRESSED(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED),
        DOWN_PRESSED(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED),
        RIGHT_PRESSED(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED),
        LEFT_PRESSED(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED),

        /* Paint */
        SPACE_PRESSED(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED),
        SPACE_RELEASE(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED),

        /* Save, Load and Quit */
        S_RELEASE(KeyboardEvent.KEY_S, KeyboardEventType.KEY_RELEASED),
        L_RELEASE(KeyboardEvent.KEY_L, KeyboardEventType.KEY_RELEASED),
        Q_PRESS(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_PRESSED);

        public final int keyNum;
        public final KeyboardEventType type;

        Key (int keyNum, KeyboardEventType type) {
            this.keyNum = keyNum;
            this.type = type;
        }
    }
}
