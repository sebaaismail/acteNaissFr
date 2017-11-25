package com.sebaainf.ismThemes;

import com.jgoodies.looks.Fonts;

import java.awt.*;

/**
 * Created by ${sebaainf.com} on 24/02/2015.
 */
public class DefaultTheme extends MyTheme {

    public DefaultTheme() {

        this.buttonBarColor = Color.decode("#138507");
        this.buttonsBackgroundColor = Color.decode("#EAF5D7");
        this.font = Fonts.WINDOWS_VISTA_96DPI_LARGE.deriveFont(16f);

    }

}
