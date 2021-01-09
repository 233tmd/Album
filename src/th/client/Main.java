package th.client;

import javax.swing.JFrame;

import th.component.ViewerFrame;

/**
 * 图片浏览器入口类
 * 
 * @author th
 * @version  1.0
 */
public class Main {
	public  Main(){
		ViewerFrame viewerframe = new ViewerFrame();
		//EXIT_ON_CLOSE:退出应用程序后默认窗口关闭操作
		viewerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}