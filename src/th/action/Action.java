package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * ͼƬ�������Action�ӿ�
 */
public interface Action {
	/**
	 * ����ִ�еķ���
	 * @param service ͼƬ�������ҵ������
	 * @param frame ���������
	 */
	void execute(ViewerService service, ViewerFrame frame);
}
