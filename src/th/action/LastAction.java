package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;


/**
 * 上一张图片的Action
 */
public class LastAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.last(frame);
	}

}
