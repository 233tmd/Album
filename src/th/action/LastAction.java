package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;


/**
 * ��һ��ͼƬ��Action
 */
public class LastAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.last(frame);
	}

}
