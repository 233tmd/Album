package th.client;

import javax.swing.JFrame;

import th.component.ViewerFrame;

/**
 * ͼƬ����������
 * 
 * @author th
 * @version  1.0
 */
public class Main {
	public  Main(){
		ViewerFrame viewerframe = new ViewerFrame();
		//EXIT_ON_CLOSE:�˳�Ӧ�ó����Ĭ�ϴ��ڹرղ���
		viewerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}