package com.sebaainf.ismThemes;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ${sebaainf.com} on 24/02/2015.
 */
public abstract class MyTheme {

    public Color buttonBarColor;
    public Color buttonsBackgroundColor;
    public Font font;

    protected Font helloAppFont() {
        //create the font
        Font customFont = null;


        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            InputStream is = MyTheme.class.getResourceAsStream("comic.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, is);
            ge.registerFont(customFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return customFont.deriveFont(20f);
    }
}
