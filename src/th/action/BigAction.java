package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * ·Å´óÍ¼Æ¬µÄAction
 * 
 */
public class BigAction implements Action {

	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, true);
	}

}
