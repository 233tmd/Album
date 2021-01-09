package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * ��ͼƬ�ļ���Action
 */
public class OpenAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.open(frame);
	}

}
