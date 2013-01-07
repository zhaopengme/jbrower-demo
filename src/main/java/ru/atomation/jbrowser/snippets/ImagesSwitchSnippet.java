/**
 * No restrictions for this source.
 *
 * Author: CA>>>
 * Site: atomation.ru
 * Mail: Sashusik_EntXXI@Mail.ru
 */
package ru.atomation.jbrowser.snippets;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ru.atomation.jbrowser.impl.JBrowserBuilder;
import ru.atomation.jbrowser.impl.JBrowserCanvas;
import ru.atomation.jbrowser.impl.JBrowserComponent;
import ru.atomation.jbrowser.impl.JComponentFactory;
import ru.atomation.jbrowser.interfaces.BrowserManager;

/**
 * EN: How to enable/disable images in browser 
 * RU: Как включать/отключать изображения в барузере
 * @author caiiiycuk
 */
public class ImagesSwitchSnippet {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) (screenSize.getWidth() * 0.75f),
                (int) (screenSize.getHeight() * 0.75f));
        frame.setLocationRelativeTo(null);

        BrowserManager browserManager =
                new JBrowserBuilder().buildBrowserManager();

        browserManager.getBrowserConfig().disableImages();
        
        JComponentFactory<Canvas> canvasFactory = browserManager.getComponentFactory(JBrowserCanvas.class);
        JBrowserComponent<?> browser = canvasFactory.createBrowser();
        
        frame.getContentPane().add(browser.getComponent());
        frame.setVisible(true);

        browser.setUrl("http://www.beardnote.com/");
    }
}
