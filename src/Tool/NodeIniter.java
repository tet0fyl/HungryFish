package Tool;

import View.ViewMenuPrincipal;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class NodeIniter {

    public static Label initTitle(int fontSize, String textContent){
        Label t = new Label();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontBubbleButt), fontSize));
        t.setRotate(15);
        return t;
    }

    public static Button initBtn(int fontSize, String textContent, String styleClass){
        Button b = new Button(textContent);
        b.setMinWidth(150);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        b.getStyleClass().add(styleClass);
        return b;
    }

    public static Label initText(int fontSize, String textContent){
        Label t = new Label(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        return t;
    }

}
