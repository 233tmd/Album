package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * �Ŵ�ͼƬ��Action
 * 
 */
public class BigAction implements Action {

	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, true);
	}

}
