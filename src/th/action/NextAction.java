package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * ��һ��ͼƬ��Action
 */
public class NextAction implements Action {

	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.next(frame);
	}

}
