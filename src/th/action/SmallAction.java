package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * ��СͼƬ��Action
 */
public class SmallAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, false);
	}

}
