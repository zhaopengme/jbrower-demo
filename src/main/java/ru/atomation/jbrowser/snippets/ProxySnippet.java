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
 * EN: Explains how to configure proxy for your jbrowser <br/> 
 * RU: Показывает как конфигурировать настройки прокси для вашего браузера
 * @author caiiiycuk
 */
public class ProxySnippet {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) (screenSize.getWidth() * 0.75f),
                (int) (screenSize.getHeight() * 0.75f));
        frame.setLocationRelativeTo(null);

        BrowserManager browserManager =
                new JBrowserBuilder().buildBrowserManager();

        browserManager.getBrowserConfig().setManualProxy("http://localhost", 3223, null, -1, null, -1, null, -1, null);
        
        JComponentFactory<Canvas> canvasFactory = browserManager.getComponentFactory(JBrowserCanvas.class);
        JBrowserComponent<?> browser = canvasFactory.createBrowser();
        
        frame.getContentPane().add(browser.getComponent());
        frame.setVisible(true);

        browser.setUrl("http://code.google.com/p/jbrowser/");
    }
}
